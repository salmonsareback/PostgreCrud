package com.adeo.postgreCrud.controllers;

import com.adeo.postgreCrud.services.DataSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestsController {
	@Autowired
	DataSeeder dataSeeder;

	@GetMapping("/seed")
	public void seed() {
		dataSeeder.seedData();
	}
}
