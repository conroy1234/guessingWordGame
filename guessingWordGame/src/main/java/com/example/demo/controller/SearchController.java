package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Guesses;
import com.example.demo.repository.GuessesRepository;
import com.example.demo.repository.SecretRepository;
import com.example.demo.service.GuessesService;

@RestController
@RequestMapping("/api")
public class SearchController {
	
	@Autowired
	SecretRepository secretRepository;
	@Autowired
	GuessesRepository guessesRepository;
	@Autowired
	GuessesService guessesService;
	
	@GetMapping("/search/{searchWord}/{result}")
	public List<Guesses>  findSecretSearch(@PathVariable String searchWord,@PathVariable String result){
		guessesService.getSearchWord(searchWord);
		Guesses guess = guessesService.search(result);
		guess.setId(guess.getId()+1);
		guess.setGuesses(searchWord);
		guess.setNumberofSearches(1);
		//guessesRepository.save(guess);
		
		
		List<Guesses> resultList =guessesRepository.findAll();
		return  resultList;
	
	}
	


}
