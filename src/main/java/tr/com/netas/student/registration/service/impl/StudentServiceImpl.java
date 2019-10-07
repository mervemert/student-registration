package tr.com.netas.student.registration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.netas.student.registration.dao.StudentDao;
import tr.com.netas.student.registration.entity.Student;
import tr.com.netas.student.registration.service.StudentService;
import tr.com.netas.student.registration.validation.ValidateUtil;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;


    public void saveOrUpdate(Student student) {
        Student studentById = studentDao.getStudentById(student.getId());
        if (ValidateUtil.isEmpty(studentById))
            studentDao.addStudent(student);
        else
            studentDao.updateStudent(student);
    }

    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }

    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    public List<Student> findAllStudent() {
        return studentDao.findAllStudent();
    }


}
