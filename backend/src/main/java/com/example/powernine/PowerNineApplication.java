package com.example.powernine;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import com.example.powernine.studnet.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

public class PowerNineApplication {

	public static void main(String[] args) {
		SpringApplication.run(PowerNineApplication.class, args);
	}


}
