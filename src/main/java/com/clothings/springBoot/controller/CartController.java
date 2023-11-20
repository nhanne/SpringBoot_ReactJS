package com.clothings.springBoot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.clothings.springBoot.mapper.OrderDetailMapper;
import com.clothings.springBoot.mapper.OrdersMapper;
import com.clothings.springBoot.mapper.ProductMapper;
import com.clothings.springBoot.mapper.UserMapper;
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
	@Autowired
	OrdersMapper orderMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	OrderDetailMapper detailMapper;

	public List<CartItem> getCart() {
		List<CartItem> listCart = (List<CartItem>) httpSession.getAttribute("cart");
		if (listCart == null) {
			listCart = new ArrayList<>();
			httpSession.setAttribute("cart", listCart);
		}
		return listCart;
	}

	private double totalPrice() {
		double iTotalPrice = 0;
		List<CartItem> listCart = getCart();
		if (listCart.size() > 0) {
			for (CartItem item : listCart) {
				iTotalPrice += item.getTotalPrice();
			}
		}
		return iTotalPrice;
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

	@PostMapping("/checkout")
	public ResponseEntity<String> CheckOut(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("phone") String phone, @RequestParam("streets") String streets,
			@RequestParam("note") String note) {
		List<CartItem> listCart = getCart();
		if (listCart.size() > 0) {
			Map<String, Object> paramsUser = new HashMap<>();
			paramsUser.put("email", email);
			paramsUser.put("name", name);
			paramsUser.put("phone", phone);
			userMapper.insertUser(paramsUser);
			Integer userId = (Integer) paramsUser.get("id");
			Map<String, Object> paramsOrder = new HashMap<>();
			paramsOrder.put("streets", streets);
			paramsOrder.put("status", "Chưa giao hàng");
			paramsOrder.put("note", note);
			paramsOrder.put("ordtime", new Date());
			paramsOrder.put("delitime", new Date());
			paramsOrder.put("totalPrice", totalPrice());
			paramsOrder.put("userId", userId);
			int totalQuantity = 0;
			for (CartItem item : listCart) {
				totalQuantity += item.getQuantity();
			}
			paramsOrder.put("totalQuantity", totalQuantity);
			orderMapper.insertOrder(paramsOrder);
			Integer orderId = (Integer) paramsOrder.get("id");

			for (CartItem item : listCart) {
				Map<String, Object> paramsDetail = new HashMap<>();
				paramsDetail.put("orderId", orderId);
				paramsDetail.put("productId", item.getProductId());
				paramsDetail.put("Quantity", item.getQuantity());
				paramsDetail.put("UnitPrice", item.getUnitPrice());
				detailMapper.insertDetail(paramsDetail);
			}
		}

		return ResponseEntity.ok("Đặt hàng thành công");
	}

}
