package tr.com.example.student.registration.dao;

import tr.com.example.student.registration.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(int id);

    Student findById(int id);

    Optional<Student> findByStudentId(Long studentId);

    List<Student> getAllStudent();

}
