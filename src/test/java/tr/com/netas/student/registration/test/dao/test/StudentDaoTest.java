package tr.com.netas.student.registration.test.dao.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tr.com.netas.student.registration.dao.StudentDao;
import tr.com.netas.student.registration.entity.Student;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/application-context.xml")

public class StudentDaoTest {

    private static final int EXISTING_ID = 3202;
    private static final Long STUDENT_ID = 12121212L;
    private static final String NAME = "Test name";
    private static final String SURNAME = "Test surname";
    private static final String MOBILE_PHONE_NUMBER = "(234) 324-2342";
    private static final String CITY = "Ankara";
    private static final String DISTRICT = "Yenimahalle";
    private static final String DESCRIPTION = "Test Description";

    @Autowired
    private StudentDao studentDao;

    private Student student;


    @Before
    public void setUp() {
        student = Student.builder().studentId(STUDENT_ID)
                .name(NAME)
                .surname(SURNAME)
                .city(CITY)
                .district(DISTRICT)
                .mobilePhoneNumber(MOBILE_PHONE_NUMBER)
                .description(DESCRIPTION)
                .build();
    }

    @Test
    public void findById() {
        Student student = studentDao.findById(EXISTING_ID);
        assertTrue(!Objects.isNull(student));
    }


    @Test
    public void addStudent() {
        studentDao.addStudent(student);
        Student tempStudent = studentDao.findById(EXISTING_ID);
        assertThat(student).isEqualToIgnoringGivenFields(tempStudent, "id");
    }


    @Test
    public void updateStudent() {
        Student student = studentDao.findById(EXISTING_ID);
        student.setName("new name");
        studentDao.updateStudent(student);
        Assert.assertEquals(student.getName(), studentDao.findById(student.getId()).getName());
    }

    @Test
    public void findByStudentId() {
        Student student = studentDao.findById(EXISTING_ID);
        assertTrue(!Objects.isNull(student));
    }


    @Test
    public void getAllStudents() {
        List<Student> allStudent = studentDao.getAllStudent();
        assertTrue(!Objects.isNull(allStudent));
    }

    @Test
    public void deleteStudent() {
        Student student = studentDao.findById(EXISTING_ID);
        studentDao.deleteStudent(student.getId());
        Assert.assertNull(studentDao.findById(student.getId()));
    }


}
