package com.rural.post.office.customer.repository;

import com.rural.post.office.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    boolean existsByAccountNumber(String accountNumber);
}
