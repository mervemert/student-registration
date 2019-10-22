package tr.com.example.student.registration.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tr.com.example.student.registration.controller.StudentController;
import tr.com.example.student.registration.entity.City;
import tr.com.example.student.registration.entity.District;
import tr.com.example.student.registration.service.CityService;
import tr.com.example.student.registration.service.StudentService;
import tr.com.example.student.registration.entity.Student;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

import static org.mockito.Mockito.*;


public class StudentControllerUTest {

    public static final int STUDENT_ID = 123;
    public static final String NAME = "testName";
    public static final String SURNAME = "testSurname";

    @Mock
    StudentService studentService;
    @Mock
    CityService cityService;
    @Mock
    Student student;
    @Mock
    ConcurrentMap<City, District> cityDistrictMap;
    @Mock
    List<City> cityList;

    @InjectMocks
    StudentController testObj;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        when(cityService.getAllCity()).thenReturn(cityList);
        when(cityService.getAllDistrict()).thenReturn(cityDistrictMap);
    }

    @Test
    public void addStudent() {
        when(student.getId()).thenReturn(STUDENT_ID);
        when(student.getName()).thenReturn(NAME);
        when(student.getSurname()).thenReturn(SURNAME);

        testObj.addStudent();

        verify(studentService, times(1)).saveStudent(student);
    }


    @Test
    public void updateStudent(){
        testObj.updateStudent(student);
        verify(studentService, times(1)).updateStudent(student);
    }

    @Test
    public void deleteStudent(){
        when(student.getId()).thenReturn(STUDENT_ID);
        testObj.deleteStudent(student);

        verify(studentService, times(1)).deleteStudent(STUDENT_ID);

    }


    @Test
    public void getStudentList(){
        testObj.getStudentList();
        verify(studentService, times(1)).getAllStudent();
    }

}