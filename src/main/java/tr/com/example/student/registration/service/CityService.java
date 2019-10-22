package tr.com.example.student.registration.service;

import tr.com.example.student.registration.entity.District;
import tr.com.example.student.registration.entity.City;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

public interface CityService {

    List<City> getAllCity();

    ConcurrentMap<City, District> getAllDistrict();
}
