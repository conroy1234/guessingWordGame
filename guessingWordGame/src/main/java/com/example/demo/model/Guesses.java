package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Guesses {
	
	@Id
	private int id;
	private String guesses;
	private int numberofSearches;	
	private String secritWord;
	
	
	
	public Guesses() {
		
	}


	public Guesses(String guesses, int numberofSearches, String secritWord) {
	
		this.guesses = guesses;
		this.numberofSearches = numberofSearches;
		this.secritWord = secritWord;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGuesses() {
		return guesses;
	}
	public void setGuesses(String guesses) {
		this.guesses = guesses;
	}
	public int getNumberofSearches() {
		return numberofSearches;
	}
	public void setNumberofSearches(int numberofSearches) {
		this.numberofSearches = numberofSearches;
	}
	public String getSecritWord() {
		return secritWord;
	}
	public void setSecritWord(String secritWord) {
		this.secritWord = secritWord;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((guesses == null) ? 0 : guesses.hashCode());
		result = prime * result + id;
		result = prime * result + numberofSearches;
		result = prime * result + ((secritWord == null) ? 0 : secritWord.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guesses other = (Guesses) obj;
		if (guesses == null) {
			if (other.guesses != null)
				return false;
		} else if (!guesses.equals(other.guesses))
			return false;
		if (id != other.id)
			return false;
		if (numberofSearches != other.numberofSearches)
			return false;
		if (secritWord == null) {
			if (other.secritWord != null)
				return false;
		} else if (!secritWord.equals(other.secritWord))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Guesses [id=" + id + ", guesses=" + guesses + ", numberofSearches=" + numberofSearches + ", secritWord="
				+ secritWord + "]";
	}
	
	
}
