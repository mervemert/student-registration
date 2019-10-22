package tr.com.test.student.registration.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "STUDENT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "STUDENT_GEN_HIBERNATE")
    @TableGenerator(name = "STUDENT_GEN_HIBERNATE", initialValue = 100)
    private int id;

    @Column(name = "STUDENT_ID")
    @NotNull(message = "Student Id must not be null")
    private Long studentId;

    @Column
    @Size(min=2, max = 50)
    @NotNull(message = "Name must not be null")
    private String name;

    @Column
    @Size(min = 2, max = 50)
    @NotNull(message = "Surname must not be null")
    private String surname;

    @Column(name = "PHONE_NUMBER")
    private String mobilePhoneNumber;

    @Column
    private String city;

    @Column
    private String district;

    @Column
    @Size(max = 150, message = "Description must be max 150 character")
    @Nullable
    private String description;


    public Student(Long studentId, String name, String surname, String mobilePhoneNumber, String city, String district, String description) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.city = city;
        this.district = district;
        this.description = description;
    }

    public void initializeWithNull() {
        this.setStudentId(null);
        this.setName(null);
        this.setSurname(null);
        this.setMobilePhoneNumber(null);
        this.setCity(null);
        this.setDescription(null);
        this.setDistrict(null);
        this.setCity(null);
    }
}
