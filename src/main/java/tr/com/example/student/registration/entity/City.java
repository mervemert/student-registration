package tr.com.example.student.registration.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CITY")
public class City {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "city", cascade = CascadeType.ALL)
    private List<District> districtList;

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

    public List<District> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<District> districtList) {
        this.districtList = districtList;
    }

    @Override
    public String toString() {
        return name;
    }
}
