package ir.company.tourengine.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FACTOR")
public class FalloutFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    private Date factorDate;
    private String title;

    @Column(name = "status")
    @Type(type = "true_false")
    private Boolean status;
    private Integer count;
    private Long price;
    private Long discount;

    @ManyToOne
    @JoinColumn(name = "fk_product", referencedColumnName = "ID")
    @JsonManagedReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "ID")
    @JsonManagedReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_event", referencedColumnName = "ID")
    @JsonManagedReference
    private Event event;

    @ManyToOne
    @JoinColumn(name = "fk_seller", referencedColumnName = "ID")
    @JsonManagedReference
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "fk_transaction", referencedColumnName = "ID")
    @JsonManagedReference
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "fk_passenger", referencedColumnName = "ID")
    @JsonManagedReference
    private Passenger passenger;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFactorDate() {
        return factorDate;
    }

    public void setFactorDate(Date factorDate) {
        this.factorDate = factorDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
