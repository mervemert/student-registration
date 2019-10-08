package tr.com.netas.student.registration.service;

import tr.com.netas.student.registration.entity.Student;

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
