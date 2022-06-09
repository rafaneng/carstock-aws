package com.example.carstock.controller;

import com.example.carstock.model.Car;
import com.example.carstock.service.CarService;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping()
public class SampleController {

    @GetMapping
    public String hello(){
        return "Car's Stock API is running in Workshop!!!";
    }
}
