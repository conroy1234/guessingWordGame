package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.constants.Constants;
import com.example.demo.model.Guesses;
import com.example.demo.repository.GuessesRepository;
import com.example.demo.repository.SecretRepository;

@Service
public class GuessesService {

	@Autowired
	SecretRepository secretRepository;

	@Autowired
	GuessesRepository guessesRepository;

	public String getSearchWord(String searchWord) {
		return secretRepository.findBysearchWord(searchWord);
	}

	public Iterable<Guesses> getCorrectGuess() {
		return guessesRepository.findAll();
	}

	public void saveGuesses(Guesses guess) {
		guessesRepository.save(guess);
	}
	
	
	public Guesses search(String searchWord) {
		int numberOfPlayers = 0;
		Guesses guess = new Guesses();

		// while the word search is not equal to secret word it will iterate for 9 times
		
		guess.setSecritWord(Constants.SECRET_TORD);
		//guess.setGuesses(searchWord);
		
		while (!guess.getSecritWord().equalsIgnoreCase(searchWord) && (Constants.NUMBER_OG_SEARCHES < 9)) {
			Constants.NUMBER_OG_SEARCHES++;
			guess.setNumberofSearches(Constants.NUMBER_OG_SEARCHES);
			System.out.println("Enter a guess !");
			guess.setGuesses(searchWord);
			
			
			if (guess.getNumberofSearches() == 9) {
				System.exit(0);
			}
			while (numberOfPlayers < 4) {
				numberOfPlayers++;

				if (numberOfPlayers == 4) {
					numberOfPlayers = 0;
				}
				guess.setId(guess.getId()+1);
				if(searchWord.equals("SECRETWORD")) {
					System.out.println("SECRETWORD");
				}
				if(guess.getGuesses().equals("SECRETWORD")) {
					System.out.println(" The gust value is SECRETWORD");
				}
				if (searchWord.equalsIgnoreCase(guess.getSecritWord())) {
					//guess = new Guesses(getSearchWord(searchWord),Constants.NUMBER_OG_SEARCHES, guess.getGuesses());
					guess.setId(guess.getId()+1);
					saveGuesses(guess);
				System.out.println(
							"Player : number " + numberOfPlayers + ": is Correct! " + Constants.GUESSES + " it right");
					break;
				} else
					System.out.println("Player : #" + numberOfPlayers + ": icorrect please try again!");
				break;

			}

		}
		System.out.println("You are correct!");
		return guess;
	}
}
