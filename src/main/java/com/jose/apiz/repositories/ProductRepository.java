package com.jose.apiz.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jose.apiz.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
