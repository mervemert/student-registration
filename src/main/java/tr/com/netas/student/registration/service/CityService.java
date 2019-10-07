package tr.com.netas.student.registration.service;

import tr.com.netas.student.registration.entity.City;
import tr.com.netas.student.registration.entity.District;

import java.util.List;
import java.util.Map;

public interface CityService {

    List<City> getAllCity();

    Map<City, District> getAllDistrict();
}
