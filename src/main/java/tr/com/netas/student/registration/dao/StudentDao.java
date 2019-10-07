package tr.com.netas.student.registration.dao;

import tr.com.netas.student.registration.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(int id);

    Student findById(int id);

    Optional<Student> findByStudentId(String studentId);

    List<Student> getAllStudent();

}
