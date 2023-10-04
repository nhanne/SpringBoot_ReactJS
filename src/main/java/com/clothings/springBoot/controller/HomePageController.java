package com.clothings.springBoot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.clothings.springBoot.mapper.ProductMapper;
import com.clothings.springBoot.model.Product;
import com.clothings.springBoot.model.ProductExample;

@Controller
public class HomePageController {

	@Autowired
	ProductMapper productMapper;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
	@GetMapping("/store")
	public ModelAndView store() {
		ModelAndView modelAndView = new ModelAndView("store");
		return modelAndView;
	}

	@GetMapping("/products")
	public ResponseEntity<List<Map<String, Object>>> products(
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "sort", required = false) String sort,
			@RequestParam(name = "category", required = false) Integer category) {
		Map<String, Object> params = new HashMap<>();
	    if (name != null && !name.isEmpty()) {
	        params.put("name", name);
	    }
	    
	    if (sort != null && !sort.isEmpty()) {
	        params.put("sort", sort);
	    }
	    
	    if (category != null) {
	        params.put("category", category);
	    }

		List<Map<String, Object>> listProducts = productMapper.getProducts(params);

		return ResponseEntity.ok(listProducts);
	}

}
