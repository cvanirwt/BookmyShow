package com.booking.controller;

import com.booking.entity.City;
import com.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class MovieBookingController {
    @Autowired
    private BookingService cityService;

    @GetMapping("/city/{id}")
    public ResponseEntity<City> getBookingById(@PathVariable("id") Integer id) {
        City city = cityService.getCityById(id);
        return new ResponseEntity<City>(city, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<City>> getAllActiveBookings() {
        List<City> list = cityService.getAllCities();
        return new ResponseEntity<List<City>>(list, HttpStatus.OK);
    }

    @PostMapping("/city")
    public ResponseEntity<Void> createBooking(@RequestBody City city, UriComponentsBuilder builder) {
        boolean flag = cityService.addCity(city);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/city/{id}").buildAndExpand(city.getCityId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/city/update")
    public ResponseEntity<City> updateCity(@RequestBody City city) {
        cityService.updateCity(city);
        return new ResponseEntity<City>(city, HttpStatus.OK);
    }
} 