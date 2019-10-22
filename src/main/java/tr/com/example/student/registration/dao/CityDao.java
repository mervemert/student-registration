package tr.com.example.student.registration.dao;

import tr.com.example.student.registration.entity.City;
import tr.com.example.student.registration.entity.District;

import java.util.List;
import java.util.concurrent.ConcurrentMap;


public interface CityDao {
    List<City> getAllCity();

    ConcurrentMap<City, District> getAllDistrict();
}
