package com.example.powernine;

import com.example.powernine.user.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserTests {

	@Autowired
	UserController userController;

	@Test
	void contextLoads() {

	}

}
