package com.guettafa.cachingwithspring.service;

import com.guettafa.cachingwithspring.dto.CreateCustomerDto;
import com.guettafa.cachingwithspring.dto.CustomerInfoDto;
import com.guettafa.cachingwithspring.exception.CustomerNotFound;
import com.guettafa.cachingwithspring.model.Customer;
import com.guettafa.cachingwithspring.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    @Cacheable("customers")
    public CustomerInfoDto getByUsername(String username) {
        return CustomerInfoDto.from(
                customerRepository.findByUsername(username)
                        .orElseThrow(CustomerNotFound::new)
        );
    }

    @CachePut(value = "customers", key = "#dto.username()")
    public CustomerInfoDto addCustomer(CreateCustomerDto dto) {
        return CustomerInfoDto.from(customerRepository.save(Customer
                .builder()
                        .email(dto.email())
                        .username(dto.username())
                        .password(dto.password())
                .build())
        );
    }

}
