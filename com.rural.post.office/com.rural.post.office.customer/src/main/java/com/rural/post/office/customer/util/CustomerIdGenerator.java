package com.rural.post.office.customer.util;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class CustomerIdGenerator {

    private static final SecureRandom random = new SecureRandom();

    public String generateCustomerId(String name) {
        String letters = name.replaceAll("[^A-Za-z]", "").toUpperCase();
        StringBuilder id = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            id.append(letters.charAt(random.nextInt(letters.length())));
            id.append(random.nextInt(10));
        }
        return id.substring(0, 8);
    }

    public String generateAccountNumber() {
        return String.valueOf(1000000000L + random.nextInt(900000000));
    }
}
