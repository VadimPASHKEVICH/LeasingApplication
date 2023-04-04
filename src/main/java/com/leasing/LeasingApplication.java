package com.leasing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class LeasingApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeasingApplication.class, args);

    }

}
