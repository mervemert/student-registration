package tr.com.netas.student.registration.service;

import tr.com.netas.student.registration.entity.Student;

import java.util.List;

public interface StudentService {

   void saveOrUpdate(Student student);

    void deleteStudent(int id);

    Student getStudentById(int id);

    List<Student> findAllStudent();

}
