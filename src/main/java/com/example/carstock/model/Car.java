package com.example.carstock.model;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Car extends RepresentationModel<Car> implements Serializable {

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_generator")
    @SequenceGenerator(name = "car_generator", sequenceName = "s_car", allocationSize = 1)
    @Column(name = "id", nullable = false, precision = 19, scale = 0)
    private long id;

    @Column(name = "make", nullable = false, length = 255)
    private String make;

    @Column(name = "model", nullable = false, length = 255)
    private String model;

    @Column(name = "license_plate", nullable = false, length = 7)
    private String licensePlate;

    @Column(name = "manufacture_year", nullable = true, length = 4)
    private Integer manufactureYear;

    @Column(name = "date_created", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    public Car(){}

    public Car(long id, String make, String model, String licensePlate, Integer manufactureYear, Date dateCreated) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.licensePlate = licensePlate;
        this.manufactureYear = manufactureYear;
        this.dateCreated = dateCreated;
    }

    public Car(String make, String model, String licensePlate, Integer manufactureYear) {
        this.make = make;
        this.model = model;
        this.licensePlate = licensePlate;
        this.manufactureYear = manufactureYear;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(Integer manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && make.equals(car.make) && model.equals(car.model) && licensePlate.equals(car.licensePlate) && Objects.equals(manufactureYear, car.manufactureYear) && dateCreated.equals(car.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, make, model, licensePlate, manufactureYear, dateCreated);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", manufactureYear=" + manufactureYear +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
