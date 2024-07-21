package com.guettafa.cachingwithspring.dto;

import com.guettafa.cachingwithspring.model.Customer;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record CustomerInfoDto (
        String email,
        String username
) implements Serializable {
    public static CustomerInfoDto from(Customer customer) {
        return CustomerInfoDto
                .builder()
                    .email(customer.getEmail())
                    .username(customer.getUsername())
                .build();
    }
}
