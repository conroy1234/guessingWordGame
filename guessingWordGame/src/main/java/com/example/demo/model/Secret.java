package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Secret {

	@Id
	public String searchWord;

	public Secret() {

	}

	public Secret(String searchWord) {
		super();
		this.searchWord = searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getSearchWord() {
		return searchWord;
	}

	@Override
	public String toString() {
		return "Secret [searchWord=" + searchWord + "]";
	}

}
