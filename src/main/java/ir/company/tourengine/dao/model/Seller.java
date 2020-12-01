package ir.company.tourengine.dao.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SELLER")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String des;


    @OneToMany(mappedBy = "seller")
    @JsonBackReference
    private List<FalloutFactor> falloutFactors;

    @OneToMany(mappedBy = "seller")
    @JsonBackReference
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<FalloutFactor> getFalloutFactors() {
        return falloutFactors;
    }

    public void setFalloutFactors(List<FalloutFactor> falloutFactors) {
        this.falloutFactors = falloutFactors;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
