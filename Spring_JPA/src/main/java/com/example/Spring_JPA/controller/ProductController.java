package com.example.Spring_JPA.controller;

import com.example.Spring_JPA.entity.Product;
import com.example.Spring_JPA.exception.ResourceNotFoundException;
import com.example.Spring_JPA.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/*
 *Note:
 * + RestController: annotation: đánh dấu 1 lớp là 1 Restful Controller
 * ==> @RestController = @Controller + @ResponseBody
 * + @RequestMapping: ánh xạ các yêu cầu HTTP đến các phương thức xử lý tương ứng trong một RESTful Controller.
 * + @Autowired:  sử dụng để tự động chèn (inject) các dependency vào một bean
 * ==> Spring sẽ tự động tìm kiếm các bean phù hợp để chèn vào đó.
 * + @PathVariable được sử dụng để ràng buộc giá trị của biến productId với đoạn mã trong URL.
 * @GetMapping: Hiển thị dữ liệu = Read
 * @PostMapping: Thêm dữ liệu = Create
 * @PutMapping: Cập nhật dữ liệu = Update
 * @DeleteMapping: Xoá dữ liệu = Delete
 *  */
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    public ProductRepository productRepository;
    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProduct(@RequestParam(required = false) String nameProduct) {
        List<Product> products = new ArrayList<>();

        if (nameProduct == null)
            productRepository.findAll().forEach(products::add);
        else
            productRepository.findByNameProductContaining(nameProduct).forEach(products::add);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping("/product")
    public ResponseEntity<Product> createTutorial(@RequestBody Product product) {
        Product _product = productRepository.save(new Product(product.getNameProduct(), product.getPrice(), product.getQuantity(), product.getDescription()));
        return new ResponseEntity<>(_product, HttpStatus.CREATED);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        Product _product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found product with id = " + id));

        _product.setNameProduct(product.getNameProduct());
        _product.setPrice(product.getPrice());
        _product.setQuantity(product.getQuantity());
        _product.setDescription(product.getDescription());

        return new ResponseEntity<>(productRepository.save(_product), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductId(@PathVariable("id") Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Product with id = " + id));

        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") Integer id) {
        productRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
