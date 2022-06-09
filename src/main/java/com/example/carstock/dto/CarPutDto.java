package com.example.carstock.dto;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class CarPutDto {

    private long id;
    @NotNull
    private String make;
    @NotNull
    private String model;
    @NotNull
    private String licensePlate;
    @NotNull
    private Integer manufactureYear;

    public CarPutDto() {}

    public CarPutDto(long id, String make, String model, String licensePlate, Integer manufactureYear) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPutDto carPutDto = (CarPutDto) o;
        return id == carPutDto.id && make.equals(carPutDto.make) && model.equals(carPutDto.model) && licensePlate.equals(carPutDto.licensePlate) && Objects.equals(manufactureYear, carPutDto.manufactureYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, make, model, licensePlate, manufactureYear);
    }
}
