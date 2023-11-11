package com.clothings.springBoot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.clothings.springBoot.mapper.ProductMapper;
import com.clothings.springBoot.model.CartItem;
import com.clothings.springBoot.model.Product;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private HttpSession httpSession;
	@Autowired
	ProductMapper productMapper;

	public List<CartItem> getCart() {
		List<CartItem> listCart = (List<CartItem>) httpSession.getAttribute("cart");
		if (listCart == null) {
			listCart = new ArrayList<>();
			httpSession.setAttribute("cart", listCart);
		}
		return listCart;
	}

	@PostMapping("/add")
	public ResponseEntity<String> addItem(@RequestParam("productId") Integer productId) {
		List<CartItem> listCart = getCart();
		boolean found = false;
		for (CartItem item : listCart) {
			if (item.getProductId().equals(productId)) {
				item.setQuantity();
				found = true;
				break;
			}
		}
		if (found) {

		} else {
			Product product = productMapper.productCart(productId);
			CartItem item = new CartItem(product);
			listCart.add(item);
		}
		return ResponseEntity.ok("Added product with ID: " + productId);

	}

	@PostMapping("/remove")
	public String removeItem(@RequestParam("productId") Integer productId) {
		List<CartItem> listCart = getCart();

		for (CartItem item : listCart) {
			if (item.getProductId().equals(productId)) {
				listCart.remove(item);
				break;
			}
		}
		return "ok";
	}

	@GetMapping
	public ModelAndView cart() {
		List<CartItem> listCart = getCart();
		ModelAndView modelAndView = new ModelAndView("cart");
		modelAndView.addObject("cart", listCart);
		return modelAndView;
	}

	
}
