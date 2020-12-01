package ir.company.tourengine.dao.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    private String fName;
    private String lName;
    private String email;
    private String mobile;
    private String roll;
    private String birthday;
    private String nationalCode;
    private String vCode;
    private String password;
    private Integer age;
    @Column(name = "SUB_USER")
    @Type(type = "true_false")
    private Boolean subUser;

    @OneToOne(mappedBy = "user")
    private Tour tour;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<FalloutFactor> falloutFactors;


    @ManyToOne
    @JoinColumn(name = "fk_passenger", referencedColumnName = "ID")
    @JsonManagedReference
    private Passenger passenger;

    public List<FalloutFactor> getFalloutFactors() {
        return falloutFactors;
    }

    public void setFalloutFactors(List<FalloutFactor> falloutFactors) {
        this.falloutFactors = falloutFactors;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSubUser() {
        return subUser;
    }

    public void setSubUser(Boolean subUser) {
        this.subUser = subUser;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getvCode() {
        return vCode;
    }

    public void setvCode(String vCode) {
        this.vCode = vCode;
    }
}
