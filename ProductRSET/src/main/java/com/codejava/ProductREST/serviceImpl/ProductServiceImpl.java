package com.codejava.ProductREST.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejava.ProductREST.domain.Product;
import com.codejava.ProductREST.repository.ProductRepository;
import com.codejava.ProductREST.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository repo;

	public List<Product> listAll() {
		return repo.findAll();
	}

	@Override
	public void save(Product product) {
		repo.save(product);
	}

	@Override
	public Product get(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Product> findById(Integer id) {
		return repo.findById(id);
	}
}
