package com.example.powernine;

import com.example.powernine.card.Card;
import com.example.powernine.deck.Deck;
import com.example.powernine.deck.DeckRepository;
import com.example.powernine.deck.utils.DeckNotFoundException;
import com.example.powernine.user.User;
import com.example.powernine.user.UserController;
import com.example.powernine.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserTests {

	@Autowired
	UserController controller;

	@Autowired
	UserRepository userRepository;

	@Autowired
	DeckRepository deckRepository;

	/**
	 * Create user with 5 random cards in database.
	 *
	 * @throws IOException If unable to properly query scryfall API
	 */
	private Deck createUserWithDeck() throws IOException {
		userRepository.deleteAll();
		deckRepository.deleteAll();
		User user = new User("User1", "password", "Tommy", "Trojan",
				"tommyt@usc.edu", "ROLE_USER");
		Deck deck = new Deck("deck1", new ArrayList<>());
		for (int i = 0; i < 5; i++) {
			deck.addCard(Card.random());
		}
		ArrayList<Deck> decks = new ArrayList<>();
		decks.add(deck);
		user.setDecks(decks);
		userRepository.save(user);
		deckRepository.save(deck);
		return deck;
	}

	/**
	 * Test Case 1 (Black box): getDeckByID(int).
	 *
	 * Integers corresponding to valid entries in the table should return JSON blobs representing each table entry.
	 * The data that is returned should exactly correspond to the proper table entry.
	 */
	@Test
	void testCast1() throws IOException, DeckNotFoundException {
		Deck deck = createUserWithDeck();
		User user = userRepository.findByUsername("User1");
		Optional<Deck> deckInRepo = deckRepository.findById(deck.getId());
		if (deckInRepo.isPresent()) {
			assertEquals(deckInRepo.get(), deck);
		} else {
			throw new DeckNotFoundException(deck.getId());
		}
		assertEquals(deck, user.getDeckByID(deck.getId()));
	}

	/**
	 * Test Case 2 (Black box): getDeckByID(int).
	 *
	 * Integers corresponding to invalid entries in the table should return an empty list.
	 */
	@Test
	void testCase2() throws IOException {
		createUserWithDeck();
		User user = userRepository.findByUsername("User1");
		Long id = 12312321L;
		Optional<Deck> deckInRepo = deckRepository.findById(id);
		assertFalse(deckInRepo.isPresent());
		assertThrows(DeckNotFoundException.class, () -> user.getDeckByID(id));
	}

	/**
	 * Test Case 3 (Black box): getDeckByName(string).
	 *
	 * Strings corresponding to valid usernames in the User table will return JSON blocks corresponding to the
	 * table entry. The data that is returned should exactly correspond to the proper table entry.
	 */
	@Test
	void testCase3() throws IOException {
		createUserWithDeck();
		User user = userRepository.findByUsername("User1");
		Deck deck = user.getDeckByName("deck1");
		Optional<Deck> deckInRepo = deckRepository.findById(deck.getId());
		if (deckInRepo.isPresent()) {
			assertEquals(deckInRepo.get(), deck);
		} else {
			throw new DeckNotFoundException("deck1");
		}
	}

	/**
	 * Test Case 4 (Black box): getDeckByName(string).
	 *
	 * Strings corresponding to invalid usernames in the User table will return an empty list.
	 */
	@Test
	void testCase4() throws IOException {
		createUserWithDeck();
		assertNull(userRepository.findByUsername("user23423"));
	}

	/**
	 * Test Case 5 (Black box): getDeckByName(string).
	 *
	 * An empty string should return an empty list.
	 */
	@Test
	void testCase5() throws IOException {
		createUserWithDeck();
		User user = userRepository.findByUsername("User1");
		assertThrows(DeckNotFoundException.class, () -> user.getDeckByName(""));
	}

}
