package tr.com.netas.student.registration.dao;

import tr.com.netas.student.registration.entity.City;
import tr.com.netas.student.registration.entity.District;

import java.util.List;
import java.util.concurrent.ConcurrentMap;


public interface CityDao {
    List<City> getAllCity();

    ConcurrentMap<City, District> getAllDistrict();
}
