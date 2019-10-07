package tr.com.netas.student.registration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.netas.student.registration.dao.CityDao;
import tr.com.netas.student.registration.entity.City;
import tr.com.netas.student.registration.entity.District;
import tr.com.netas.student.registration.service.CityService;

import java.util.List;
import java.util.Map;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;


    public List<City> getAllCity() {
        return cityDao.getAllCity();
    }

    public Map<City, District> getAllDistrict() {
        return cityDao.getAllDistrict();
    }
}
