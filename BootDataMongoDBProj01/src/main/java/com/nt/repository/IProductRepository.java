//IProductRepository.java(24.05.2025)
package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.nt.document.Product;

public interface IProductRepository extends MongoRepository<Product, String>{

}
