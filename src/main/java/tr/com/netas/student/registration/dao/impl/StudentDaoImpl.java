package tr.com.netas.student.registration.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tr.com.netas.student.registration.dao.StudentDao;
import tr.com.netas.student.registration.entity.Student;

import java.util.List;

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
        Student studentToRemove = getStudentById(id);
        if (studentToRemove != null)
            sessionFactory.getCurrentSession().delete(studentToRemove);
    }

    public Student getStudentById(int id) {
        return  (Student)sessionFactory.getCurrentSession().get(Student.class, id);
    }

    public List<Student> findAllStudent() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Student");
        return query.list();
    }


}
