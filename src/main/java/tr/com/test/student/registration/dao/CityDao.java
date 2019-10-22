package tr.com.test.student.registration.dao;

import tr.com.test.student.registration.entity.City;
import tr.com.test.student.registration.entity.District;

import java.util.List;
import java.util.concurrent.ConcurrentMap;


public interface CityDao {
    List<City> getAllCity();

    ConcurrentMap<City, District> getAllDistrict();
}
