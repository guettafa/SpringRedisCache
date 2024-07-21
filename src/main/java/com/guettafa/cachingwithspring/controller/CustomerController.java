package com.guettafa.cachingwithspring.controller;

import com.guettafa.cachingwithspring.dto.CreateCustomerDto;
import com.guettafa.cachingwithspring.dto.CustomerInfoDto;
import com.guettafa.cachingwithspring.service.CustomerService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable String username) {
        try {
            return new ResponseEntity<>(customerService.getByUsername(username), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(CreateCustomerDto dto) {
        try {
            return new ResponseEntity<>(customerService.addCustomer(dto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
