package com.example.carstock.dto;

import javax.persistence.Column;
import java.util.Objects;

public class CarPostDto {

    private String make;
    private String model;
    private String licensePlate;
    private Integer manufactureYear;

    public CarPostDto() {}

    public CarPostDto(String make, String model, String licensePlate, Integer manufactureYear) {
        this.make = make;
        this.model = model;
        this.licensePlate = licensePlate;
        this.manufactureYear = manufactureYear;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPostDto that = (CarPostDto) o;
        return make.equals(that.make) && model.equals(that.model) && licensePlate.equals(that.licensePlate) && Objects.equals(manufactureYear, that.manufactureYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, licensePlate, manufactureYear);
    }
}
