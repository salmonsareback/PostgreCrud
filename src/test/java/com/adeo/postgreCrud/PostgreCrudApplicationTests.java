package com.adeo.postgreCrud;

import com.adeo.postgreCrud.services.DataSeeder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostgreCrudApplicationTests {
	@Autowired
	DataSeeder dataSeeder;

	@Test
	void contextLoads() {
	}

	@Test
	void seedDatabase(){
		dataSeeder.seedData();
	}

}
