package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Secret;

@Repository
public interface SecretRepository extends CrudRepository<Secret, String> {

	String findBysearchWord(String searchWord);

}
