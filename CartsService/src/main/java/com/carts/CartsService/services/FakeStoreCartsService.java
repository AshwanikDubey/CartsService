package com.carts.CartsService.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreCartsService implements CartsService{
	
	RestTemplate restTemplate;
	
	public FakeStoreCartsService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Override
	public String getCartById(long id) {
		// TODO Auto-generated method stub
		return "FakeStoreCartsService is called"+id;
	}

}
