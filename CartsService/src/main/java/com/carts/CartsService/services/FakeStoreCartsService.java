package com.carts.CartsService.services;

import org.springframework.stereotype.Service;

@Service
public class FakeStoreCartsService implements CartsService{

	@Override
	public String getCartById() {
		// TODO Auto-generated method stub
		return "FakeStoreCartsService is called";
	}

}
