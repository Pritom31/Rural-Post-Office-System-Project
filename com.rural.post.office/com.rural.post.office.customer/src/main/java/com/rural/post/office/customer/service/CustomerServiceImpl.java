package com.rural.post.office.customer.service;

import com.rural.post.office.customer.dto.CustomerRequestDto;
import com.rural.post.office.customer.dto.CustomerResponseDto;
import com.rural.post.office.customer.entity.Customer;
import com.rural.post.office.customer.mapper.CustomerMapper;
import com.rural.post.office.customer.repository.CustomerRepository;
import com.rural.post.office.customer.util.CustomerIdGenerator;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerIdGenerator customerIdGenerator;
    @Autowired
    CustomerMapper customerMapper;

    /* ============================
      ADMIN – CREATE CUSTOMER
      ============================ */
    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public CustomerResponseDto createCustomer(CustomerRequestDto request) {

        log.info("Admin creating customer: {}", request.getEmail());

        String customerId = generateUniqueCustomerId(request.getCustomerName());
        String accountNumber = generateUniqueAccountNumber();

        Customer customer =
                customerMapper.toEntity(request, customerId, accountNumber);

        Customer savedCustomer = customerRepository.save(customer);

        log.info("Customer created successfully. CustomerId={}", customerId);

        return customerMapper.toDto(savedCustomer);
    }

    /* ============================
       ADMIN – UPDATE CUSTOMER
       ============================ */
    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public CustomerResponseDto updateCustomer(String customerId,
                                              CustomerRequestDto request) {

        log.info("Admin updating customer: {}", customerId);

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Customer not found with id: " + customerId));

        customer.setCustomerName(request.getCustomerName());
        customer.setEmail(request.getEmail());
        customer.setPhoneNumber(request.getPhoneNumber());
        customer.setAddress(request.getAddress());
        customer.setNomineeName(request.getNomineeName());

        Customer updated = customerRepository.save(customer);

        log.info("Customer updated successfully: {}", customerId);

        return customerMapper.toDto(updated);
    }

    /* ============================
       ADMIN – DELETE CUSTOMER
       ============================ */
    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteCustomer(String customerId) {

        log.warn("Admin deleting customer: {}", customerId);

        if (!customerRepository.existsById(customerId)) {
            throw new ResourceNotFoundException(
                    "Customer not found with id: " + customerId);
        }

        customerRepository.deleteById(customerId);

        log.info("Customer deleted successfully: {}", customerId);
    }

    /* ============================
       ADMIN + CUSTOMER – GET BY ID
       ============================ */
    @Override
    @PreAuthorize("hasAnyRole('ADMIN','CUSTOMER')")
    public CustomerResponseDto getCustomerById(String customerId) {

        log.info("Fetching customer details for id={}", customerId);

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Customer not found with id: " + customerId));

        return customerMapper.toDto(customer);
    }

    /* ============================
       ADMIN – GET ALL CUSTOMERS
       ============================ */
    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<CustomerResponseDto> getAllCustomers() {

        log.info("Admin fetching all customers");

        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toDto)
                .toList();
    }

    /* ============================
       INTERNAL – UNIQUE ID LOGIC
       ============================ */

    private String generateUniqueCustomerId(String customerName) {
        String customerId;
        int attempts = 0;

        do {
            customerId = customerIdGenerator.generateCustomerId(customerName);
            attempts++;

            if (attempts > 5) {
                throw new BusinessException(
                        "Unable to generate unique customer ID");
            }
        } while (customerRepository.existsById(customerId));

        return customerId;
    }

    private String generateUniqueAccountNumber() {
        String accountNumber;
        int attempts = 0;

        do {
            accountNumber = customerIdGenerator.generateAccountNumber();
            attempts++;

            if (attempts > 5) {
                throw new BusinessException(
                        "Unable to generate unique account number");
            }
        } while (customerRepository.existsByAccountNumber(accountNumber));

        return accountNumber;
    }

}
