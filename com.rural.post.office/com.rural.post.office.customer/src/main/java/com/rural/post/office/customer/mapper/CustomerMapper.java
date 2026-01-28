package com.rural.post.office.customer.mapper;

import com.rural.post.office.customer.dto.CustomerRequestDto;
import com.rural.post.office.customer.dto.CustomerResponseDto;
import com.rural.post.office.customer.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toEntity(CustomerRequestDto dto,
                             String customerId,
                             String accountNumber) {

        return Customer.builder()
                .customerId(customerId)
                .customerName(dto.getCustomerName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .address(dto.getAddress())
                .nomineeName(dto.getNomineeName())
                .accountNumber(accountNumber)
                .build();
    }

    public CustomerResponseDto toDto(Customer customer) {
        return CustomerResponseDto.builder()
                .customerId(customer.getCustomerId())
                .customerName(customer.getCustomerName())
                .accountNumber(customer.getAccountNumber())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .address(customer.getAddress())
                .nomineeName(customer.getNomineeName())
                .createdAt(customer.getCreatedAt())
                .build();
    }
}
