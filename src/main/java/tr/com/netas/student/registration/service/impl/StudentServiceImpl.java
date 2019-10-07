package tr.com.netas.student.registration.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.netas.student.registration.dao.StudentDao;
import tr.com.netas.student.registration.entity.Student;
import tr.com.netas.student.registration.exception.ItemNotFoundException;
import tr.com.netas.student.registration.service.StudentService;
import tr.com.netas.student.registration.util.ValidateUtil;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentDao studentDao;

    @Override
    public void saveStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        Student studentById = studentDao.findById(student.getId());
        if (ValidateUtil.isNotEmpty(studentById)) {
            studentDao.updateStudent(student);
        } else {
            LOGGER.error("item not found");
        }
    }

    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }

    @Override
    public Student findById(int id) {
        return studentDao.findById(id);
    }

    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }

    @Override
    public Optional<Student> findByStudentId(String studentId) {
        return studentDao.findByStudentId(studentId);
    }

}
