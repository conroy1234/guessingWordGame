package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.model.Guesses;
import com.example.demo.model.Secret;
import com.example.demo.repository.GuessesRepository;
import com.example.demo.repository.SecretRepository;
import com.example.demo.service.GuessesService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GuessingWordGameApplication.class)
@WebAppConfiguration
public class GuessingWordGameApplicationTests {

	@Autowired
	WebApplicationContext context;

	@Autowired
	GuessesRepository guessesRepository;

	@Autowired
	SecretRepository secretRepository;

	MockMvc mockMvc;

	GuessesService guessesService = mock(GuessesService.class);
	Guesses guesses = mock(Guesses.class);

	Guesses entry;
	List<Guesses> entries;
	List<Secret> secrets;
	Secret Secret;
	String incorrectSearch = "search";
	String correctSearch = "SECRETWORD";

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		entry = guessesRepository.save(new Guesses("SECRETWORD", 9, "SECRETWORD"));

		entries = (List<Guesses>) guessesRepository.findAll();
		secrets = (List<Secret>) secretRepository.findAll();
	}

	@Test
	public void persistsGuestbookEntry() {
		int expected = 2;
		assertEquals(expected, entries.size());
	}

	@Test
	public void contextLoads() throws Exception {

		mockMvc.perform(get("/api/search/SECRETWORD/SECRETWORD")).andExpect(status().isOk());

	}

	@Test
	public void testMultiPlayersIncorrect() {
		Secret secret = new Secret();
		String searchWord = secretRepository.findBysearchWord(incorrectSearch);
		secret.setSearchWord(searchWord);
		guessesService.search(secret.getSearchWord());

		when(guessesService.search(incorrectSearch)).thenReturn(guesses).thenReturn(guesses).thenReturn(guesses)
				.thenReturn(guesses).thenReturn(guesses).thenReturn(guesses);
		assertNull(secret.getSearchWord());
	}

	@Test
	public void testcorrectSearch() {
		Secret secret = new Secret();
		String searchWord = secretRepository.findBysearchWord(correctSearch);
		secret.setSearchWord(searchWord);
		guessesService.search(secret.getSearchWord());
		when(guessesService.search(correctSearch)).thenReturn(guesses);
		assertNotNull(secret.getSearchWord());
		assertEquals(searchWord, secret.getSearchWord());
	}

}
