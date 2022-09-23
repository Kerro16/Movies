package com.movies.Movies.service;

import com.movies.Movies.entity.Product;
import com.movies.Movies.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> list(){
        return productRepository.findAll();
    }

    public Optional<Product> getOne(int id){
        return productRepository.findById(id);
    }

    public Optional<Product> getByTitle(String title){
        return productRepository.findByTitle(title);
    }

    public void save (Product product){
        productRepository.save(product);
    }

    public void delete(int id){
        productRepository.deleteById(id);
    }

    public boolean existById(int id){
        return productRepository.existsById(id);
    }

    public  boolean existByTitle(String title){
        return productRepository.existsByTitle(title);
    }

}
