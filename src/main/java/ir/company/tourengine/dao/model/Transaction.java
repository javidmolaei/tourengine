package ir.company.tourengine.dao.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {
    @Id
    @GenericGenerator(name = "myID", strategy = "increment")
    @GeneratedValue(generator = "myID")
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    private Long amount;
    private Long orderId;
    private Date transactionDate;

    @OneToMany(mappedBy = "transaction")
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

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
