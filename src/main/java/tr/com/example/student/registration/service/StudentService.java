package tr.com.example.student.registration.service;

import tr.com.example.student.registration.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    void saveStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(int id);

    Student findById(int id);

    List<Student> getAllStudent();

    Optional<Student> findByStudentId(Long studentId);

}
