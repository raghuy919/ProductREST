package com.codejava.ProductREST.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductViewController {

	@RequestMapping("/")
	public String renderIndex() {
		return "index";
	}
	
	@RequestMapping("/product")
	public String renderProductForm(@RequestParam(required = false) Integer id) {
		return "product";
	}
}
