package com.rural.post.office.customer.service;

import com.rural.post.office.customer.dto.CustomerRequestDto;
import com.rural.post.office.customer.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    CustomerResponseDto createCustomer(CustomerRequestDto request);

    CustomerResponseDto updateCustomer(String customerId, CustomerRequestDto request);

    void deleteCustomer(String customerId);

    CustomerResponseDto getCustomerById(String customerId);

    List<CustomerResponseDto> getAllCustomers();
}
