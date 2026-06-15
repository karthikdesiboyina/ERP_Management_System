package com.example.erp_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.example.erp_management_system",
        "com.example.erp_management_system"
})
public class ErpManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpManagementSystemApplication.class, args);
    }
}