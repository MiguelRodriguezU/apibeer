package com.mrodriguezul.apibeer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrodriguezul.apibeer.bean.Beer;
import com.mrodriguezul.apibeer.service.BeerService;

@RestController
@RequestMapping("/apibeer")
@CrossOrigin(origins = "*")
public class BeerController {
	
	@Autowired
	private BeerService beerServiceImpl;	
	
	
	@GetMapping(value = "/health")
	public String health(){
		return "Api beer is working!";
	}	
	
	@GetMapping(value = "/beers", produces = "application/json;charset=utf-8")
	public ResponseEntity<List<Beer>> getBeers(@RequestParam(name = "beer_name", required = false) String beerName){
		
		Optional<String> beerNameSpecified = Optional.ofNullable(beerName);	
		
		List<Beer> lstBeer;
		if(beerNameSpecified.isPresent()) {
			lstBeer = beerServiceImpl.listByName(beerNameSpecified.get());
		}else {
			lstBeer = beerServiceImpl.list();
		}
		
		if(lstBeer.size() > 0) {
			return new ResponseEntity<List<Beer>>(lstBeer, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Beer>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value = "/beers/random", produces = "application/json;charset=utf-8")
	public ResponseEntity<Beer> getBeerRandom(){
		List<Beer> lstBeer = beerServiceImpl.listByRandom();
		if(lstBeer.size() > 0) {
			return new ResponseEntity<Beer>(lstBeer.get(0), HttpStatus.OK);
		}else {
			return new ResponseEntity<Beer>(HttpStatus.NO_CONTENT);
		}
	}

}
