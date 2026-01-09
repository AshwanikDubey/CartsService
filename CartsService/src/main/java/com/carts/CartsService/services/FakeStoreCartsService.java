package com.carts.CartsService.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.carts.CartsService.dtos.FakeStoreCartDto;
import com.carts.CartsService.dtos.ProductDTO;
import com.carts.CartsService.models.Carts;
import com.carts.CartsService.models.Product; 

@Service
public class FakeStoreCartsService implements CartsService{
	
	RestTemplate restTemplate;
	
	public FakeStoreCartsService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Override
	public Carts getCartById(long id) { 
		FakeStoreCartDto fakestoredto=restTemplate.getForObject("https://fakestoreapi.com/carts/"+id,
				FakeStoreCartDto.class);	
		return convertDtoToObject(fakestoredto);
	}
	
	private Carts convertDtoToObject(FakeStoreCartDto fakestoredto) { 
		   if (fakestoredto == null) {
		        return null;
		    }

		    Carts cart = new Carts();
		    cart.setId(fakestoredto.getId());
		    cart.setUserid(fakestoredto.getUserId());

		    // Convert LocalDateTime to String (since Carts uses String for date)
		    if (fakestoredto.getDate() != null) {
		        cart.setDate(fakestoredto.getDate().toString());
		    }

		    // Map first product from DTO list (if available)
		    if (fakestoredto.getProducts() != null && !fakestoredto.getProducts().isEmpty()) {
		        ProductDTO productDTO = fakestoredto.getProducts().get(0);
		        Product product = new Product();
		        product.setProductId(productDTO.getProductId());
		        product.setQuantity(productDTO.getQuantity());
		        cart.setProduct(product);
		    }
		    return cart;
	}

}
