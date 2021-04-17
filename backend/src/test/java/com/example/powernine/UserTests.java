package com.example.powernine;

import com.example.powernine.user.User;
import com.example.powernine.user.UserController;
import com.example.powernine.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserTests {

	@Autowired
	UserController controller;

	@Autowired
	UserRepository repository;

	private static User createUserWithDeck() {

	}

	/**
	 * Test Case 1 (Black box): getDeckByID(int).
	 *
	 * Integers corresponding to valid entries in the table should return JSON blobs representing each table entry.
	 * The data that is returned should exactly correspond to the proper table entry.
	 */
	@Test
	void testCast1() {

	}

	/**
	 * Test Case 2 (Black box): getDeckByID(int).
	 *
	 * Integers corresponding to invalid entries in the table should return an empty list.
	 */
	@Test
	void testCase2() {

	}

	/**
	 * Test Case 3 (Black box): getDeckByName(string).
	 *
	 * Strings corresponding to valid usernames in the User table will return JSON blocks corresponding to the
	 * table entry. The data that is returned should exactly correspond to the proper table entry.
	 */
	@Test
	void testCase3() {

	}

	/**
	 * Test Case 4 (Black box): getDeckByName(string).
	 *
	 * Strings corresponding to invalid usernames in the User table will return an empty list.
	 */
	@Test
	void testCase4() {

	}

	/**
	 * Test Case 5 (Black box): getDeckByName(string).
	 *
	 * An empty string should return an empty list.
	 */
	@Test
	void testCase5() {

	}

}
