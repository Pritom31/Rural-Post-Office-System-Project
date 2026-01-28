package com.rural.post.office.customer.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class CustomerResponseDto {
    private String customerId;
    private String customerName;
    private String phoneNumber;
    private String email;
    private String address;
    private String accountNumber;
    private String nomineeName;
    private LocalDateTime createdAt;
}
