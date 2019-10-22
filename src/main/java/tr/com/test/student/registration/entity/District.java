package tr.com.test.student.registration.entity;

import javax.persistence.*;

@Entity
@Table(name = "DISTRICT")
public class District {

    @Id
    private int id;

    private String name;

    @ManyToOne
    private City city;


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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return name;
    }
}
