package com.carts.CartsService.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.carts.CartsService.dtos.FakeStoreCartDto;

@Service
public class FakeStoreCartsService implements CartsService{
	
	RestTemplate restTemplate;
	
	public FakeStoreCartsService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Override
	public String getCartById(long id) {
		restTemplate.getForObject("https://fakestoreapi.com/carts/"+id, FakeStoreCartDto.class);
		
		return "FakeStoreCartsService is called"+id;
	}

}
