package tr.com.netas.student.registration.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tr.com.netas.student.registration.dao.CityDao;
import tr.com.netas.student.registration.entity.City;
import tr.com.netas.student.registration.entity.District;

import java.util.*;

@Repository
public class CityDaoImpl implements CityDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<City> getAllCity() {
        Query query = sessionFactory.getCurrentSession().createQuery("from City");
        List<City> resultList = query.list();
        return resultList;
    }

    @Transactional
    public  Map<City, District> getAllDistrict() {
        Map<City, District> hashMap = new HashMap<City, District>();
        String hql = "from City as city inner join city.districtList as district";
        List<?> list = sessionFactory.getCurrentSession().createQuery(hql).list();
        for (int i = 0; i < list.size(); i++) {
            Object[] row = (Object[]) list.get(i);
            City city = (City) row[0];
            District district = (District) row[1];
            hashMap.put(city, district);
        }

        return hashMap;

    }
}
