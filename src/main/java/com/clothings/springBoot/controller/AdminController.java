package com.clothings.springBoot.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.clothings.springBoot.mapper.OrderDetailMapper;
import com.clothings.springBoot.mapper.OrdersMapper;
import com.clothings.springBoot.mapper.ProductMapper;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	ProductMapper productMapper;
	@Autowired
	OrdersMapper ordersMapper;
	@Autowired
	OrderDetailMapper orderDetailMapper;
	@GetMapping
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("admin");
		return modelAndView;
	}

	@GetMapping("/orders")
	public ModelAndView orders() {
		ModelAndView modelAndView = new ModelAndView("orders");
		Map<String, Object> params = new HashMap<>();
		List<Map<String, Object>> listOrders = ordersMapper.getOrders(params);
		modelAndView.addObject("listOrders", listOrders);
		return modelAndView;
	}
	@GetMapping("/orders/detail")
	public ModelAndView ordersDetail(@RequestParam Integer id) {
		Map<String, Object> params = new HashMap<>();
		params.put("orderId", id);
		List<Map<String, Object>> model = orderDetailMapper.getOrderDetail(params);
		ModelAndView modelAndView = new ModelAndView("orderDetail");
		modelAndView.addObject("products", model);
		modelAndView.addObject("model", model.get(0));
		return modelAndView;
	}
	@PostMapping("/orders/detail")
	public ResponseEntity<String> confirmOrder(@RequestParam("orderId") Integer Id) {
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("orderId", Id);
			params.put("status", "Hoàn thành");
			ordersMapper.updateOrder(params);
			return new ResponseEntity<>("Tiếp nhận đơn hàng", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Lỗi xảy ra", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/products")
	public ModelAndView products() {
		Map<String, Object> params = new HashMap<>();
		List<Map<String, Object>> listProducts = productMapper.getProducts(params);
		ModelAndView modelAndView = new ModelAndView("products");
		modelAndView.addObject("listProducts", listProducts);
		return modelAndView;
	}

	@GetMapping("/product/create")
	public ModelAndView create() {

		ModelAndView modelAndView = new ModelAndView("createProduct");
		return modelAndView;
	}

	@PostMapping("/product/create")
	public ResponseEntity<String> createProduct(
			@RequestParam("file") MultipartFile file,
			@RequestParam("categoryid") Integer categoryid, 
			@RequestParam("name") String name,
			@RequestParam("code") String code, 
			@RequestParam("unitprice") Float unitprice) {
		try {
			String uploadPath = System.getProperty("user.dir") + "/src/main/resources/static/images/sp/";
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists()) {
				uploadDir.mkdirs();
			}
			String filePath = uploadPath + File.separator + file.getOriginalFilename();
			File dest = new File(filePath);
			file.transferTo(dest);
			Map<String, Object> params = new HashMap<>();
			params.put("categoryId", categoryid);
			params.put("picture", file.getOriginalFilename());
			params.put("name", name);
			params.put("code", code);
			params.put("unitPrice", unitprice);
			params.put("stockInDate", new Date());
			productMapper.insertProduct(params);
			return new ResponseEntity<>("Thêm sản phẩm thành công", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Lỗi khi xử lý tệp", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/product/delete")
	public ResponseEntity<String> deleteProduct(@RequestParam Integer id) {
		try {
			productMapper.deleteProductById(id);
			return new ResponseEntity<>("Xóa sản phẩm thành công", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Xóa sản phẩm thất bại", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/product/update")
	public ModelAndView update(@RequestParam Integer id) {
		List<Map<String, Object>> product = productMapper.getProductById(id);
		ModelAndView modelAndView = new ModelAndView("updateProduct");
		modelAndView.addObject("product", product);
		return modelAndView;
	}
	@PostMapping("/product/update")
	public ResponseEntity<String> updateProduct(
			@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam("productId") Integer productId, 
			@RequestParam("categoryId") Integer categoryId, 
			@RequestParam("name") String name,
			@RequestParam("code") String code, 
			@RequestParam("unitprice") Float unitprice) {
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("productId", productId);
			params.put("categoryId", categoryId);
			if(file != null) {
				String uploadPath = System.getProperty("user.dir") + "/src/main/resources/static/images/sp/";
				File uploadDir = new File(uploadPath);
				if (!uploadDir.exists()) {
					uploadDir.mkdirs();
				}
				String filePath = uploadPath + File.separator + file.getOriginalFilename();
				File dest = new File(filePath);
				file.transferTo(dest);
				params.put("picture", file.getOriginalFilename());
			}
			params.put("name", name);
			params.put("code", code);
			params.put("unitPrice", unitprice);
			params.put("stockInDate", new Date());
			productMapper.updateProduct(params);
			return new ResponseEntity<>("Chỉnh sửa sản phẩm thành công", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Lỗi khi xử lý", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
