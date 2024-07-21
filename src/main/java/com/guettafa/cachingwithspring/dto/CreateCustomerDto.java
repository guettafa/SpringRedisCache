package com.guettafa.cachingwithspring.dto;

import lombok.Builder;

@Builder
public record CreateCustomerDto(
        String username,
        String email,
        String password
) { }
