package com.rural.post.office.customer.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class CustomerRequestDto {
    @NonNull
    private String customerName;
    private String phoneNumber;
    @NonNull
    private String email;
    private String address;
    private String nomineeName;
}
