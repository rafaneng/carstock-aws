package com.example.carstock.repository;

import com.example.carstock.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByLicensePlate(String licensePlate);
}
