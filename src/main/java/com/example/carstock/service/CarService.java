package com.example.carstock.service;

import com.example.carstock.dto.CarPatchDto;
import com.example.carstock.dto.CarPostDto;
import com.example.carstock.dto.CarPutDto;
import com.example.carstock.exception.BadRequestException;
import com.example.carstock.model.Car;
import com.example.carstock.repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class CarService {
	
	private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Page<Car> listAll(Pageable pageable) {
        return carRepository.findAll(pageable);
    }
    public List<Car> listAllNonPageable() {
        return carRepository.findAll();
    }
    public List<Car> findByLicensePlate(String licensePlate){
        return carRepository.findByLicensePlate(licensePlate);
    }

    public Car findByIdOrThrowBadRequestException(long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Car not found"));
    }

    @Transactional
    public Car save(CarPostDto carToCreate) {
        Car carCreated = new Car(carToCreate.getMake(), carToCreate.getModel(), carToCreate.getLicensePlate(), carToCreate.getManufactureYear());
        carCreated.setDateCreated(new Date());
        return carRepository.save(carCreated);
    }

    public void delete(long id) {
        carRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replaceAll(CarPutDto car) {
        Car carToReplace = findByIdOrThrowBadRequestException(car.getId());

        carToReplace.setMake(car.getMake());
        carToReplace.setModel(car.getModel());
        carToReplace.setLicensePlate(car.getLicensePlate());
        carToReplace.setManufactureYear(car.getManufactureYear());

        carRepository.save(carToReplace);
    }

//    public void replace(CarPatchDto car) {
//        Car carToReplace = findByIdOrThrowBadRequestException(car.getId());
//
//        carToReplace.setModel(car.getModel().orElseGet(() -> carToReplace.getModel()));
//        carToReplace.setMake(car.getMake().orElseGet(() -> carToReplace.getMake()));
//        carToReplace.setLicensePlate(car.getLicensePlate().orElseGet(() -> carToReplace.getLicensePlate()));
//        carToReplace.setManufactureYear(car.getManufactureYear().orElseGet(() -> carToReplace.getManufactureYear()));
//
//        carRepository.save(carToReplace);
//    }

}
