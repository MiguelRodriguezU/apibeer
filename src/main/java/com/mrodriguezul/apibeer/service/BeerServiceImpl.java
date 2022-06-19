package com.mrodriguezul.apibeer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.mrodriguezul.apibeer.bean.Beer;

@Service
public class BeerServiceImpl implements BeerService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${beer.path}")
	private String apiBeerPath;

	@Override
	public List<Beer> list() {
		List<Beer> lstBeers = new ArrayList<Beer>();
		try {
			ResponseEntity<List<Beer>> responseEntity = restTemplate.exchange(apiBeerPath, HttpMethod.GET, null, new ParameterizedTypeReference<List<Beer>>() {});
			lstBeers = responseEntity.getBody();
		} catch (RestClientResponseException e) {
			System.out.println(e.getRawStatusCode());
			System.out.println(e.getResponseBodyAsString());
		}
		return lstBeers;
	}

	@Override
	public List<Beer> listByName(String beerName) {
		String uriByName = apiBeerPath + "?beer_name=" + beerName;
		List<Beer> lstBeers = new ArrayList<Beer>();
		try {
			ResponseEntity<List<Beer>> responseEntity = restTemplate.exchange(uriByName, HttpMethod.GET, null, new ParameterizedTypeReference<List<Beer>>() {});
			lstBeers = responseEntity.getBody();
		} catch (RestClientResponseException e) {
			System.out.println(e.getRawStatusCode());
			System.out.println(e.getResponseBodyAsString());
		}
		return lstBeers;
	}

	@Override
	public List<Beer> listByRandom() {
		String uriRandom = apiBeerPath + "/random";
		List<Beer> lstBeers = new ArrayList<Beer>();
		try {
			ResponseEntity<List<Beer>> responseEntity = restTemplate.exchange(uriRandom, HttpMethod.GET, null, new ParameterizedTypeReference<List<Beer>>() {});
			lstBeers = responseEntity.getBody();
		} catch (RestClientResponseException e) {
			System.out.println(e.getRawStatusCode());
			System.out.println(e.getResponseBodyAsString());
		}		
		return lstBeers;
	}

}
