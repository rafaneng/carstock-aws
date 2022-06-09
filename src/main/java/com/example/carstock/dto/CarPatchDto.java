package com.example.carstock.dto;

import javax.validation.constraints.Null;
import java.util.Objects;
import java.util.Optional;

public class CarPatchDto {

    private long id;
    private Optional<String> make;
    private Optional<String> model;
    private Optional<String> licensePlate;
    private Optional<Integer> manufactureYear;

    public CarPatchDto() {}

    public CarPatchDto(long id, Optional<String> make, Optional<String> model, Optional<String> licensePlate, Optional<Integer> manufactureYear) {
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

    public Optional<String> getMake() {
        return make;
    }

    public void setMake(Optional<String> make) {
        this.make = make;
    }

    public Optional<String> getModel() {
        return model;
    }

    public void setModel(Optional<String> model) {
        this.model = model;
    }

    public Optional<String> getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(Optional<String> licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Optional<Integer> getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(Optional<Integer> manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPatchDto carPutDto = (CarPatchDto) o;
        return id == carPutDto.id && make.equals(carPutDto.make) && model.equals(carPutDto.model) && licensePlate.equals(carPutDto.licensePlate) && Objects.equals(manufactureYear, carPutDto.manufactureYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, make, model, licensePlate, manufactureYear);
    }
}
