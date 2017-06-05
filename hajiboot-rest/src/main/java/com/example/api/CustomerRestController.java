package com.example.api;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
	@Autowired
	CustomerService customerService;
	
	//ŒÚ‹q‘SŒæ“¾
	@GetMapping
	Page<Customer> getCustomers(@PageableDefault Pageable pageable) {
		Page<Customer> customers = customerService.findAll(pageable);
		return customers;
	}
	
	//ŒÚ‹q1Œæ“¾
	@GetMapping(path = "{id}")
	Customer getCustomer(@PathVariable Integer id) {
		Customer customer = customerService.findOne(id);
		return customer;
	}
	
	//ŒÚ‹qV‹Kì¬
	@PostMapping
	ResponseEntity<Customer> postCustomer(@RequestBody Customer customer, UriComponentsBuilder uriBuilder) {
		Customer created = customerService.create(customer);
		URI location = uriBuilder.path("api/customers/{id}").buildAndExpand(created.getId()).toUri();
		return ResponseEntity.created(location).body(created);
	}
	
	//ŒÚ‹q‚PŒXV
	@PutMapping(path = "{id}")
	Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
		customer.setId(id);
		return customerService.update(customer);
	}
	
	//ŒÚ‹q‚PŒíœ
	@DeleteMapping(path = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteCustomer(@PathVariable Integer id) {
		customerService.delete(id);
	}
}
