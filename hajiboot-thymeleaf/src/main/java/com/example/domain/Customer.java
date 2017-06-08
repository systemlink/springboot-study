package com.example.domain;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue
	private Integer id;
	private String firstName;
	private String lastName;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "username")
	private User user;
}
