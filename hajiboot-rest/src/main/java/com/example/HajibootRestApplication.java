package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;
 

@SpringBootApplication
public class HajibootRestApplication {
	public static void main(String[] args) {
		SpringApplication.run(HajibootRestApplication.class, args);
	}
}
