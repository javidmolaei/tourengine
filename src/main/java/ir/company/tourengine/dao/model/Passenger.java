package ir.company.tourengine.dao.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PASSENGERS")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;


    @OneToMany(mappedBy = "passenger")
    @JsonBackReference
    private List<FalloutFactor> falloutFactors;

    @OneToMany(mappedBy = "passenger")
    @JsonBackReference
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "passenger")
    @JsonBackReference
    private List<User> users;

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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
