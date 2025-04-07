package com.juancuero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = "com.juancuero.*")
public class MsAccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsAccountsApplication.class, args);
    }

}
