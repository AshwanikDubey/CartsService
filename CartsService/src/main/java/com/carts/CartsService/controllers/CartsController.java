package com.carts.CartsService.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carts.CartsService.models.Carts;
import com.carts.CartsService.services.CartsService;

@RestController
@RequestMapping("/carts")
public class CartsController {
	
	CartsService cartservice;
	
	public CartsController(CartsService cartservice) {
		this.cartservice = cartservice ;
	}	
	
	@GetMapping("/{id}")
	public Carts getControllerById(@PathVariable("id") Long id) {  
		return cartservice.getCartById(id);		
	}
	
}
