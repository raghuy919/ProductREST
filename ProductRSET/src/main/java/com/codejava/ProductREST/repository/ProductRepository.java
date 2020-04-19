package com.codejava.ProductREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codejava.ProductREST.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
