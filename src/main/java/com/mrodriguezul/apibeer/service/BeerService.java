package com.mrodriguezul.apibeer.service;

import java.util.List;

import com.mrodriguezul.apibeer.bean.Beer;

public interface BeerService {
	List<Beer> list();
	List<Beer> listByName(String beerName);
	List<Beer> listByRandom();
}
