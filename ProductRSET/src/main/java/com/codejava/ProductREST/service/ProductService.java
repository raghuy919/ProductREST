package com.codejava.ProductREST.service;

import java.util.List;
import java.util.Optional;

import com.codejava.ProductREST.domain.Product;

public interface ProductService {
	public List<Product> listAll();

	public void save(Product product);

	public Product get(Integer id);

	public void delete(Integer id);

	public Optional<Product> findById(Integer id);

}
