package com.movies.Movies.controller;


import com.movies.Movies.dto.Message;
import com.movies.Movies.dto.ProductDto;
import com.movies.Movies.entity.Product;
import com.movies.Movies.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<Product>> list(){
        List<Product> list = productService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") int id){
        if(!productService.existById(id))
            return new ResponseEntity(new Message("Doesn't Exist"), HttpStatus.NOT_FOUND);
            Product product = productService.getOne(id).get();
    return new ResponseEntity(product,HttpStatus.OK);
    }

    @GetMapping("/detailtitle/{title}")
    public ResponseEntity<Product> getByTitle(@PathVariable("title") String title){
        if(!productService.existByTitle(title))
            return new ResponseEntity(new Message("Doesn't Exist"), HttpStatus.NOT_FOUND);
        Product product = productService.getByTitle(title).get();
        return new ResponseEntity(product,HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductDto productDto) {
        if (StringUtils.isBlank(productDto.getTitle()))
            return new ResponseEntity<>(new Message("Title cant be blank"), HttpStatus.BAD_REQUEST);
        if (productDto.getRentalprice() == null || productDto.getRentalprice() < 0)
            return new ResponseEntity<>(new Message("Rental price cant be negative"), HttpStatus.BAD_REQUEST);
        if (productDto.getSaleprice()== null || productDto.getSaleprice() < 0)
            return new ResponseEntity<>(new Message("Sale price cant be negative"), HttpStatus.BAD_REQUEST);
        if (productDto.getStock()==null || productDto.getStock()< 0)
            return new ResponseEntity<>(new Message("Stock cant be negative"), HttpStatus.BAD_REQUEST);
        Product product = new Product(productDto.getTitle(), productDto.getDescription(),productDto.getImage(),productDto.getStock(),productDto.getRentalprice(),productDto.getSaleprice(),productDto.getAvailable());
        productService.save(product);
        return new ResponseEntity<>(new Message("Product created"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody ProductDto productDto) {
        if(!productService.existById(id))
            return new ResponseEntity(new Message("Doesn't Exist"), HttpStatus.NOT_FOUND);
        if (StringUtils.isBlank(productDto.getTitle()) && productService.getByTitle(productDto.getTitle()).get().getId() != id)
            return new ResponseEntity<>(new Message("Title already exist"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(productDto.getTitle()))
            return new ResponseEntity<>(new Message("Title cant be blank"), HttpStatus.BAD_REQUEST);
        if (productDto.getRentalprice() < 0)
        if (productDto.getRentalprice() < 0)
            return new ResponseEntity<>(new Message("Rental price cant be negative"), HttpStatus.BAD_REQUEST);
        if (productDto.getSaleprice() < 0)
            return new ResponseEntity<>(new Message("Sale price cant be negative"), HttpStatus.BAD_REQUEST);
        if (productDto.getStock() < 0)
            return new ResponseEntity<>(new Message("Stock cant be negative"), HttpStatus.BAD_REQUEST);

        Product product = productService.getOne(id).get();
        product.setTitle(product.getTitle());
        product.setDescription(productDto.getDescription());
        product.setImage(productDto.getImage());
        product.setStock(productDto.getStock());
        product.setRentalprice(productDto.getRentalprice());
        product.setSaleprice(productDto.getSaleprice());
        product.setAvailable(productDto.getAvailable());
        productService.save(product);
        return new ResponseEntity(new Message("Product updated"), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!productService.existById(id))
            return new ResponseEntity(new Message("Doesnt exist"), HttpStatus.NOT_FOUND);
        productService.delete(id);
        return new ResponseEntity<>(new Message("Product deleted"), HttpStatus.OK);

    }
    //545463
}
