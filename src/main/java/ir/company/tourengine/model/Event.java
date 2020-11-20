package ir.company.tourengine.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EVENT")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    private String location;
    private Date startDate;
    private Date endDate;
    private String startTime;
    private String endTime;
    private String description;
    private String startLocation;
    private String surpriseTour;
    private String foodsTour;

    @ManyToOne
    @JoinColumn(name = "fk_tour", referencedColumnName = "ID")
    @JsonManagedReference
    private Tour tour;

    @OneToMany(mappedBy = "event")
    @JsonBackReference
    private List<FalloutFactor> falloutFactors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public List<FalloutFactor> getFalloutFactors() {
        return falloutFactors;
    }

    public void setFalloutFactors(List<FalloutFactor> falloutFactors) {
        this.falloutFactors = falloutFactors;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getSurpriseTour() {
        return surpriseTour;
    }

    public void setSurpriseTour(String surpriseTour) {
        this.surpriseTour = surpriseTour;
    }

    public String getFoodsTour() {
        return foodsTour;
    }

    public void setFoodsTour(String foodsTour) {
        this.foodsTour = foodsTour;
    }
}
