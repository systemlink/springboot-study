package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.app.Argument;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;

@SpringBootApplication
public class HajibootDiApplication implements CommandLineRunner {
	@Autowired
	ArgumentResolver argumentResolver;
	@Autowired
	Calculator calculator;

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("Enter 2 numbers like 'a b' : ");
		Argument argument = argumentResolver.resolve(System.in);
		int result = calculator.calc(argument.getA(), argument.getB());
		System.out.println("result = " + result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(HajibootDiApplication.class, args);

	}

}
