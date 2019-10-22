package tr.com.test.student.registration.test.service.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tr.com.test.student.registration.dao.StudentDao;
import tr.com.test.student.registration.entity.Student;
import tr.com.test.student.registration.service.impl.StudentServiceImpl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class StudentServiceImplUTest {

    private static final int ID = 100;

    private static final Long STUDENT_ID = 1L;

    @Mock
    StudentDao studentDao;
    @Mock
    Student student;

    @InjectMocks
    private StudentServiceImpl testObj;

    @Before
    public void setup() {
        testObj = new StudentServiceImpl();
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void saveStudent() {
        testObj.saveStudent(student);
        verify(studentDao, times(1)).addStudent(student);
    }

    @Test
    public void updateStudent(){
        when(student.getId()).thenReturn(ID);
        when(studentDao.findById(ID)).thenReturn(student);

        testObj.updateStudent(student);

        verify(studentDao, times(1)).updateStudent(student);
    }


    @Test
    public void deleteStudent(){
        testObj.deleteStudent(ID);
        verify(studentDao, times(1)).deleteStudent(ID);
    }


    @Test
    public void findById(){
        testObj.findById(ID);

        verify(studentDao, times(1)).findById(ID);
    }

    @Test
    public void findByStudentId(){
        testObj.findByStudentId(STUDENT_ID);
    }

    @Test
    public void getAllStudent(){
        testObj.getAllStudent();
        verify(studentDao, times(1)).getAllStudent();
    }
}