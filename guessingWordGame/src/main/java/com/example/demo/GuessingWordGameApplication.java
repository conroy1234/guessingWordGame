package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Guesses;
import com.example.demo.model.Secret;
import com.example.demo.repository.GuessesRepository;
import com.example.demo.repository.SecretRepository;

@SpringBootApplication
public class GuessingWordGameApplication implements CommandLineRunner {

	@Autowired
	SecretRepository secretRepository;
	
	@Autowired
	GuessesRepository guesRepository;
	
	@Autowired
	com.example.demo.service.GuessesService  GuessesService;
	public static void main(String[] args) {
		SpringApplication.run(GuessingWordGameApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		secretRepository.save(new Secret("SECRETWORD"));
		GuessesService.saveGuesses(new Guesses("SECRETWORD",9,"SECRETWORD"));
	}

}
