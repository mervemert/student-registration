package tr.com.netas.student.registration.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tr.com.netas.student.registration.dao.StudentDao;
import tr.com.netas.student.registration.entity.Student;
import tr.com.netas.student.registration.util.ValidateUtil;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void addStudent(Student student) {
        sessionFactory.getCurrentSession().save(student);
    }

    public void updateStudent(Student student) {
        sessionFactory.getCurrentSession().update(student);
    }

    public void deleteStudent(int id) {
        Student studentToRemove = findById(id);
        if (!ValidateUtil.isEmpty(studentToRemove)) {
            sessionFactory.getCurrentSession().delete(studentToRemove);
        }
        else
            LOGGER.error("item not found");
    }

    @Override
    public Student findById(int id) {
        return sessionFactory.getCurrentSession().get(Student.class, id);
    }

    @Override
    public List<Student> getAllStudent() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Student");
        return query.list();
    }

    @Override
    public Optional<Student> findByStudentId(Long studentId) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Student s where s.studentId=:studentId");
        query.setParameter("studentId", studentId);
        Optional<Student> student = query.list().stream().findFirst();
        return student;
    }


}
