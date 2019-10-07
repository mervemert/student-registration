package tr.com.netas.student.registration.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "STUDENT_GEN_HIBERNATE")
    @TableGenerator(name = "STUDENT_GEN_HIBERNATE", initialValue = 100)
    private int id;

    @Column(name = "STUDENT_ID")
    private String studentId;

    @Column
    private String name;

    @Column
    private String surname;

    @Column(name = "PHONE_NUMBER")
    private String mobilePhoneNumber;

    @Column
    private String city;

    @Column
    private String district;

    @Column
    private String description;

    private transient boolean editable;

    public Student() {
    }

    public Student(String studentId, String name, String surname, String mobilePhoneNumber, String city, String district, String description, boolean editable) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.city = city;
        this.district = district;
        this.description = description;
        this.editable = editable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
