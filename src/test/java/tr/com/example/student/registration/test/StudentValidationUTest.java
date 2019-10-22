package tr.com.example.student.registration.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import tr.com.example.student.registration.entity.Student;

import javax.validation.ConstraintViolation;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class StudentValidationUTest {

    private static final String CITY = "Ankara";
    private static final String NAME = "testName";
    private static final String SURNAME = "testSurname";
    private static final String MOBILE_PHONE_NUMBER = "+905555555555";
    private static final String DISTRICT = "Cankaya";
    private static final String DESCRIPTION = "testDesc";
    private static final Long STUDENT_ID = 20087898L;
    private static final String INVALID_NAME = "a";
    private static final String INVALID_NAME_2 = "abcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdeabcdef";
    private static final String NAME_FIELD = "name";
    private static final String SURNAME_FIELD = "surname";
    private static LocalValidatorFactoryBean factoryBean;
    private static Student student;

    @Before
    public void setUp() {
        factoryBean = new LocalValidatorFactoryBean();
        factoryBean.afterPropertiesSet();
        student = buildStudent();
    }

    @After
    public void tearDown() {
        factoryBean.destroy();
    }

    @Test
    public void studentId_isEmpty_shouldNotValidate() {
        student.setStudentId(null);
        validateAndVerify(student, "studentId");
    }

    @Test
    public void studentId_isMoreThan11Digits_shouldNotValidate() {
        student.setStudentId(111111111111L);
        validateAndVerify(student, "studentId");
    }

    @Test
    public void studentId_isNull_shouldNotValidate() {
        student.setStudentId(null);
        validateAndVerify(student, "studentId");
    }

    @Test
    public void name_isEmpty_shouldNotValidate() {
        student.setName(StringUtils.EMPTY);
        validateAndVerify(student, NAME_FIELD);
    }

    @Test
    public void name_isNull_shouldNotValidate() {
        student.setName(StringUtils.EMPTY);
        validateAndVerify(student, NAME_FIELD);
    }

    @Test
    public void name_isLessThan2Chars_shouldNotValidate() {
        student.setName(INVALID_NAME);
        validateAndVerify(student, NAME_FIELD);
    }

    @Test
    public void name_isMoreThan50Chars_shouldNotValidate() {
        student.setName(INVALID_NAME_2);
        validateAndVerify(student, NAME_FIELD);
    }

    @Test
    public void surname_isEmpty_shouldNotValidate() {
        student.setSurname(StringUtils.EMPTY);
        validateAndVerify(student, SURNAME_FIELD);
    }

    @Test
    public void surname_isNull_shouldNotValidate() {
        student.setSurname(StringUtils.EMPTY);
        validateAndVerify(student, SURNAME_FIELD);
    }

    @Test
    public void surname_isLessThan2Chars_shouldNotValidate() {
        student.setSurname(INVALID_NAME);
        validateAndVerify(student, SURNAME_FIELD);
    }

    @Test
    public void surname_isMoreThan50Chars_shouldNotValidate() {
        student.setSurname(INVALID_NAME_2);
        validateAndVerify(student, SURNAME_FIELD);
    }


    private void validateAndVerify(Student student, String field) {
        ConstraintViolation<Student> violation = buildViolations(student);
        assertEquals(violation.getPropertyPath().toString(), field);
    }


    private Student buildStudent() {
        return Student.builder()
                .studentId(STUDENT_ID)
                .name(NAME)
                .surname(SURNAME)
                .mobilePhoneNumber(MOBILE_PHONE_NUMBER)
                .city(CITY)
                .district(DISTRICT)
                .description(DESCRIPTION)
                .build();
    }


    private ConstraintViolation<Student> buildViolations(Student student) {
        Set<ConstraintViolation<Student>> constraintViolations = factoryBean.validate(student);
        ConstraintViolation<Student> violation = constraintViolations.iterator().next();
        return violation;
    }

}