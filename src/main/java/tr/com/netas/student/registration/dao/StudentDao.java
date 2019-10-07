package tr.com.netas.student.registration.dao;

import tr.com.netas.student.registration.entity.Student;

import java.util.List;

public interface StudentDao {

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(int id);

    Student getStudentById(int id);

    List<Student> findAllStudent();


}
