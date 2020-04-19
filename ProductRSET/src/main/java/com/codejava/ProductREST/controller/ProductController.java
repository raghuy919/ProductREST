package com.codejava.ProductREST.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codejava.ProductREST.domain.Product;
import com.codejava.ProductREST.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> list() {
		return new ResponseEntity<List<Product>>(service.listAll(),HttpStatus.OK);
	}

	@PostMapping(value={"/products"},produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> add(@RequestBody Product product) {
		service.save(product);
		return new ResponseEntity<>(HttpStatus.CREATED);	
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> delete(@PathVariable Integer id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Product> update(@PathVariable Integer id, @RequestBody Product product) {
		Product dbProduct = service.get(id);
		dbProduct.setName(product.getName());
		dbProduct.setPrice(product.getPrice());
		service.save(dbProduct);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
		Product prod=service.findById(id).get();
		return new ResponseEntity<>(prod,HttpStatus.OK);
	}

}
