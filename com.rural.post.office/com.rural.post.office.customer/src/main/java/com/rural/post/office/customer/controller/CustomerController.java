package com.rural.post.office.customer.controller;

import com.rural.post.office.customer.dto.CustomerRequestDto;
import com.rural.post.office.customer.dto.CustomerResponseDto;
import com.rural.post.office.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping
    public CustomerResponseDto create(@RequestBody CustomerRequestDto dto) {
        return service.createCustomer(dto);
    }

    @GetMapping
    public List<CustomerResponseDto> getAll() {
        return service.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public CustomerResponseDto getById(@PathVariable String customerId) {
        return service.getCustomerById(customerId);
    }

    @DeleteMapping("/{customerId}")
    public void delete(@PathVariable String customerId) {
        service.deleteCustomer(customerId);
    }
}
