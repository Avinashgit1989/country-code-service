package com.country.controller;

import com.country.entity.CountryCode;
import com.country.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/")
public class CountryServiceController {
    @Autowired
    private CountryService countryService;



    @GetMapping(value = "api/countries/{page}/{size}/{q}/{sort}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<CountryCode>> getCountries(@PathVariable int page, @PathVariable int size, @PathVariable String q, @PathVariable String sort) throws Exception {

        return new ResponseEntity<>(countryService.getListOfCountry(page,size,q,sort), HttpStatus.OK);
    }

    @GetMapping(value = "api/countries/{page}/{size}/{sort}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<CountryCode>> getCountryList(@PathVariable int page, @PathVariable int size, @PathVariable String sort) throws Exception {

        return new ResponseEntity<>(countryService.getListOfCountryBySort(page,size,sort), HttpStatus.OK);
    }
}
