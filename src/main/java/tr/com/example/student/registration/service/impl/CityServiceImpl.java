package tr.com.example.student.registration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.example.student.registration.dao.CityDao;
import tr.com.example.student.registration.entity.City;
import tr.com.example.student.registration.entity.District;
import tr.com.example.student.registration.service.CityService;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public List<City> getAllCity() {
        return cityDao.getAllCity();
    }

    public ConcurrentMap<City, District> getAllDistrict() {
        return cityDao.getAllDistrict();
    }
}
