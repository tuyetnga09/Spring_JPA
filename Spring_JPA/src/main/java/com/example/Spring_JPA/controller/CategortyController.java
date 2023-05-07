package com.example.Spring_JPA.controller;

import com.example.Spring_JPA.entity.Category;
import com.example.Spring_JPA.entity.Product;
import com.example.Spring_JPA.exception.ResourceNotFoundException;
import com.example.Spring_JPA.repository.CategoryRepository;
import com.example.Spring_JPA.repository.ProductRepository;
import jakarta.transaction.Transactional;
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
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CategortyController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("/product/{productId}/category")
    // trả về một đối tượng ResponseEntity chứa danh sách các đối tượng Category.
    public ResponseEntity<List<Category>> getAllCategoryByProductId(@PathVariable(value = "productId") Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + productId));

        //ạo một danh sách rỗng để chứa các đối tượng Category.
        List<Category> categories = new ArrayList<>();
        //Lấy danh sách các đối tượng Category từ sản phẩm tìm thấy và thêm chúng vào danh sách categories.
        categories.addAll(product.getCategories());
        //Trả về đối tượng ResponseEntity chứa danh sách categories
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // @RequestBody được sử dụng để trích xuất thông tin về Category từ thân của yêu cầu HTTP.
    @Transactional
    @PostMapping("/product/{productId}/category")
    public ResponseEntity<Category> createCategory(@PathVariable(value = "productId") Integer productId,
                                                 @RequestBody Category categoryRequest) {
        //Sử dụng productRepository để tìm kiếm một sản phẩm theo productId
        Category categories = productRepository.findById(productId).map(product -> {
            //Thêm đối tượng Category mới (categoryRequest) vào danh sách các đối tượng Category của sản phẩm.
            product.getCategories().add(categoryRequest);
            //Lưu đối tượng Category mới vào cơ sở dữ liệu bằng cách sử dụng categoryRepository.
            return categoryRepository.save(categoryRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + productId));

        //Trả về đối tượng ResponseEntity chứa thông tin về Category đã được tạo
        return new ResponseEntity<>(categories, HttpStatus.CREATED);
    }

    @PutMapping("/category/{id}")
    //Phương thức xử lý yêu cầu PUT và trả về một đối tượng ResponseEntity chứa thông tin về Category đã được cập nhật
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Integer id, @RequestBody Category category) {
        //Sử dụng categoryRepository để tìm kiếm một đối tượng Category theo id.
        Category _category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Category with id = " + id));
        //Cập nhật giá trị của thuộc tính "nameCategory" của đối tượng Category đã tìm thấy từ yêu cầu PUT.
        _category.setNameCategory(category.getNameCategory());
        // Cập nhật giá trị của thuộc tính "location" của đối tượng Category đã tìm thấy từ yêu cầu PUT.
        _category.setLocation(category.getLocation());

        //ưu đối tượng Category đã cập nhật vào cơ sở dữ liệu bằng cách sử dụng categoryRepository và trả về đối tượng ResponseEntity chứa thông tin về Category đã được cập nhật
        return new ResponseEntity<>(categoryRepository.save(_category), HttpStatus.OK);
    }
}
