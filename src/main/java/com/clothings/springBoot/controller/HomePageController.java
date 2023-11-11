package com.clothings.springBoot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.clothings.springBoot.mapper.CategoryMapper;
import com.clothings.springBoot.mapper.ProductMapper;

@Controller
public class HomePageController {
	@Autowired
	ProductMapper productMapper;
	@Autowired
	CategoryMapper categoryMapper;

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
	@GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
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
	@GetMapping(value = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Map<String, Object>>> categories() {			  
		List<Map<String, Object>> listCategories = categoryMapper.getCategories();
		return ResponseEntity.ok(listCategories);
	}
	@GetMapping(value = "/getProduct", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Map<String, Object>>> getProduct(
			@RequestParam(name = "Id", required = true) Integer Id) {			  
		List<Map<String, Object>> product = productMapper.getProductById(Id);
		return ResponseEntity.ok(product);
	}
}
