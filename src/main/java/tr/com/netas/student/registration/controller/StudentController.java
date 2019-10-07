package tr.com.netas.student.registration.controller;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tr.com.netas.student.registration.entity.City;
import tr.com.netas.student.registration.entity.District;
import tr.com.netas.student.registration.entity.Student;
import tr.com.netas.student.registration.service.CityService;
import tr.com.netas.student.registration.service.StudentService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private List<City> allCity;
    private List allDistrict;
    private Map<Object, Map<String, String>> data = new HashMap<Object, Map<String, String>>();
    private String city;
    private String district;
    private Map<String, String> cities;
    private Map<String, String> districties;
    private Student selectedStudent;
    private UploadedFile file;


    @PostConstruct
    public void init() {
        addCities();
        addDistricties();
    }

    private void addDistricties() {
        Map<String, String> map = new HashMap<String, String>();

        for (Map.Entry<City, District> entry : cityService.getAllDistrict().entrySet()) {
            for (District district : entry.getKey().getDistrictList()) {
                map.put(district.getName(), district.getName());
            }
            data.put(entry.getKey().getName(), map);
            map = new HashMap<String, String>();
        }
    }

    private void addCities() {
        cities = new HashMap<String, String>();
        allCity = cityService.getAllCity();
        for (City city : allCity)
            cities.put(city.getName(), city.getName());
    }


    public void addStudent() {
        studentService.saveStudent(student);
        setFieldAsNull(student);
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

    public void onCityChange() {
        if (student.getCity() != null && !student.getCity().equals(""))
            districties = data.get(student.getCity());
        else
            districties = new HashMap<String, String>();
    }


    public void onCityChangeForUpdate(Student student) {
        this.selectedStudent = student;
        if (selectedStudent.getCity() != null && !selectedStudent.getCity().equals(""))
            districties = data.get(selectedStudent.getCity());
        else
            districties = new HashMap<String, String>();
    }

    public List<Student> getStudentList() {
        studentList =  studentService.getAllStudent();
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

    public List<City> getAllCity() {
        return allCity;
    }

    public void setAllCity(List<City> allCity) {
        this.allCity = allCity;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Map<Object, Map<String, String>> getData() {
        return data;
    }

    public void setData(Map<Object, Map<String, String>> data) {
        this.data = data;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public void setCities(Map<String, String> cities) {
        this.cities = cities;
    }

    public Map<String, String> getDistricties() {
        return districties;
    }

    public void setDistricties(Map<String, String> districties) {
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
