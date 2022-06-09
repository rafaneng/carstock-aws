package com.example.carstock.controller;

import com.example.carstock.dto.CarPatchDto;
import com.example.carstock.dto.CarPostDto;
import com.example.carstock.dto.CarPutDto;
import com.example.carstock.model.Car;
import com.example.carstock.service.CarService;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<Page<Car>> list(@ParameterObject Pageable pageable){
        Page<Car> cars = carService.listAll(pageable);
        cars.stream()
            .forEach(car -> {
                long id = car.getId();
                car.add(linkTo(methodOn(CarController.class).findById(id)).withSelfRel());
            });
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Car>> listAll(){
        List<Car> cars = carService.listAllNonPageable();
        cars.stream()
            .forEach(car -> {
                long id = car.getId();
                car.add(linkTo(methodOn(CarController.class).findById(id)).withSelfRel());
            });
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Car> findById(@PathVariable long id){
        // Forma 2 de enviar http status code
        Car car = carService.findByIdOrThrowBadRequestException(id);
        Pageable pageable = PageRequest.of(0, 20);
        car.add(linkTo(methodOn(CarController.class).list(pageable)).withRel("Cars list pageable"));
        car.add(linkTo(methodOn(CarController.class).listAll()).withRel("Cars list non pageable"));
        return ResponseEntity.ok(car);
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Car>> findByLicensePlate(@RequestParam String licensePlate){
        List<Car> cars = carService.findByLicensePlate(licensePlate);
        Pageable pageable = PageRequest.of(0, 20);
        cars.stream()
                .forEach(car -> {
                    car.add(linkTo(methodOn(CarController.class).list(pageable)).withRel("Cars list pageable"));
                    car.add(linkTo(methodOn(CarController.class).listAll()).withRel("Cars list non pageable"));
                });
        return ResponseEntity.ok(carService.findByLicensePlate(licensePlate));
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody @Valid CarPostDto car){
        return new ResponseEntity<>(carService.save(car), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        carService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody CarPutDto car){
        carService.replaceAll(car);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PatchMapping
//    public ResponseEntity<Void> replace(@RequestBody @Valid CarPatchDto car){
//        carService.replace(car);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
