package tr.com.netas.student.registration.test.dao.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import tr.com.netas.student.registration.dao.StudentDao;
import tr.com.netas.student.registration.entity.Student;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/application-context.xml")

public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;


    @Test
    public void testAddStudent() {
        Student student = new Student("12121212", "Test name", "Test surname", "52498754", "Ankara", "Mamak", "Test Description");
        studentDao.addStudent(student);

        List<Student> studentList = studentDao.getAllStudent();
        Assert.assertEquals(student.getId(), studentList.get(studentList.size() - 1).getId());
    }

    @Test
    public void testfindStudent()
    {
        Student student = studentDao.findById(1702);
        Assert.assertNotNull(student);
    }
}
