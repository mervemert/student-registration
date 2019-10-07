package tr.com.netas.student.registration.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tr.com.netas.student.registration.dao.StudentDao;
import tr.com.netas.student.registration.entity.Student;
import tr.com.netas.student.registration.exception.ItemNotFoundException;
import tr.com.netas.student.registration.validation.ValidateUtil;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

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
        if (!ValidateUtil.isEmpty(studentToRemove))
            sessionFactory.getCurrentSession().delete(studentToRemove);
        else
            throw new ItemNotFoundException("item not found");
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
    public Optional<Student> findByStudentId(String studentId) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Student s where s.studentId=:studentId");
        query.setParameter("studentId", studentId);
        Optional<Student> student = query.list().stream().findFirst();
        return student;
    }


}
