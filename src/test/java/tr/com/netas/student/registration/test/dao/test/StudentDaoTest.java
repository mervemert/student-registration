package tr.com.netas.student.registration.test.dao.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tr.com.netas.student.registration.dao.StudentDao;
import tr.com.netas.student.registration.dao.impl.StudentDaoImpl;
import tr.com.netas.student.registration.entity.Student;

import static org.junit.Assert.assertEquals;

public class StudentDaoTest {

    @Test
    public void testGetStudentById(){
        StudentDaoImpl studentDao = new StudentDaoImpl();
        Student student = studentDao.findById(1852);
        assertEquals(student.getDescription(), "weqweqeq");
    }
}
