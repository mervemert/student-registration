package tr.com.test.student.registration.service;

import tr.com.test.student.registration.entity.City;
import tr.com.test.student.registration.entity.District;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

public interface CityService {

    List<City> getAllCity();

    ConcurrentMap<City, District> getAllDistrict();
}
