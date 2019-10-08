package tr.com.netas.student.registration.controller;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.netas.student.registration.entity.City;
import tr.com.netas.student.registration.entity.District;
import tr.com.netas.student.registration.entity.Student;
import tr.com.netas.student.registration.service.CityService;
import tr.com.netas.student.registration.service.StudentService;
import tr.com.netas.student.registration.util.ValidateUtil;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.validator.ValidatorException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@ManagedBean
@ViewScoped
@Component
public class StudentController {


    @Autowired
    private StudentService studentService;

    @Autowired
    private CityService cityService;

    private List<Student> studentList;
    private Student student = new Student();
    private List<City> allCityList;
    private List allDistrict;
    private ConcurrentMap<Object, ConcurrentMap<String, String>> districtByCityData;
    private String city;
    private String district;
    private ConcurrentMap<String, String> cities;
    private ConcurrentMap<String, String> districties;
    private Student selectedStudent;
    private UploadedFile file;


    @PostConstruct
    public void init() {
        districtByCityData = new ConcurrentHashMap<>();
        populateCities();
        populateDistricties();
    }

    //populate all city as parent
    private void populateCities() {
        cities = new ConcurrentHashMap<>();
        allCityList = cityService.getAllCity();
        cities = allCityList.stream().collect(Collectors.toConcurrentMap(City::getName, City::getName));

    }

    //populate all district as child by city
    private void populateDistricties() {
        ConcurrentMap<String, String> concurrentMap = new ConcurrentHashMap<>();

        for (Map.Entry<City, District> entry : cityService.getAllDistrict().entrySet()) {
            concurrentMap = entry.getKey().getDistrictList().stream().collect(Collectors.toConcurrentMap(District::getName, District::getName));
            districtByCityData.put(entry.getKey().getName(), concurrentMap);
            concurrentMap = new ConcurrentHashMap<>();
        }
    }

    public void addStudent() {
        checkNonEmptyFields();
        studentService.saveStudent(student);
        setFieldAsNull(student);
    }

    private void checkNonEmptyFields() {
        if (ValidateUtil.isEmpty(student.getId()))
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Student Id cannot be empty", null));

        if (ValidateUtil.isEmpty(student.getName()))
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Name cannot be empty", null));

        if (ValidateUtil.isEmpty(student.getSurname()))
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Surname cannot be empty", null));
    }

    private void setFieldAsNull(Student student) {
        student.setStudentId(null);
        student.setName(null);
        student.setSurname(null);
        student.setMobilePhoneNumber(null);
        student.setCity(null);
        student.setDescription(null);
        student.setDistrict(null);
        student.setCity(null);
    }

    public void updateStudent(Student student) {
        studentService.updateStudent(student);
    }


    public void deleteStudent(Student student) {
        studentList.remove(student);
        studentService.deleteStudent(student.getId());
    }

    // populate district dynamically when selected a city in dropdown
    public void onCityChange() {
        if (student.getCity() != null && !student.getCity().equals(""))
            districties = districtByCityData.get(student.getCity());
        else
            districties = new ConcurrentHashMap<>();
    }


    public void onCityChangeForUpdate(Student student) {
        this.selectedStudent = student;
        if (selectedStudent.getCity() != null && !selectedStudent.getCity().equals(""))
            districties = districtByCityData.get(selectedStudent.getCity());
        else
            districties = new ConcurrentHashMap<>();
    }

    public List<Student> getStudentList() {
        studentList = studentService.getAllStudent();
        return studentList;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }


    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<City> getAllCityList() {
        return allCityList;
    }

    public void setAllCityList(List<City> allCityList) {
        this.allCityList = allCityList;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public ConcurrentMap<Object, ConcurrentMap<String, String>> getDistrictByCityData() {
        return districtByCityData;
    }

    public void setDistrictByCityData(ConcurrentMap<Object, ConcurrentMap<String, String>> districtByCityData) {
        this.districtByCityData = districtByCityData;
    }

    public ConcurrentMap<String, String> getCities() {
        return cities;
    }

    public void setCities(ConcurrentMap<String, String> cities) {
        this.cities = cities;
    }

    public ConcurrentMap<String, String> getDistricties() {
        return districties;
    }

    public void setDistricties(ConcurrentMap<String, String> districties) {
        this.districties = districties;
    }

    public List getAllDistrict() {
        return allDistrict;
    }

    public void setAllDistrict(List allDistrict) {
        this.allDistrict = allDistrict;
    }

    public Student getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
}
