package com.dictionary.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Dictionary;

@RestController
@EnableAutoConfiguration
public class DictController {
	
	Set<String> words = new HashSet<>();

	@RequestMapping(value="/word", method=RequestMethod.POST)
	public void addWord(@RequestBody Dictionary dict) {
		words.addAll(dict.getWords());
	}
	
	@RequestMapping(value="/word", method=RequestMethod.GET)
	public String searchWords(@RequestParam("word") String word) {
		return "The word you are searching for " + word + (words.contains(word) ? " contains " : " doesn't contain ") + " in the list";
	}
	
	@RequestMapping(value="/words", method=RequestMethod.GET)
	public Set<String> listWords() {
		return words;
	}
}
