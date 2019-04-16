package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.service.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<Product> create(@RequestBody ProductDTO productDTO){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setRegularPrice(productDTO.getRegularPrice());
        product.setCategory(productDTO.getCategory());
        product.setDescription(productDTO.getDescription());
        product.setDiscount(productDTO.getDiscount());
        product.setDiscountedPrice(productDTO.getDiscountedPrice());
        productService.create(product);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable("id") Long id){
        Product product = productService.findById(id);
        return new ProductDTO(product.getId(), product.getName(), product.getRegularPrice(),
                product.getCategory(), product.getDescription(), product.getDiscount(),
                product.getDiscountedPrice());
    }

    @GetMapping(params = "name")
    public ProductDTO findByName(@RequestParam("name") String name){
        Product product = productService.findByName(name);
        return new ProductDTO(product.getId(), product.getName(), product.getRegularPrice(),
                product.getCategory(), product.getDescription(), product.getDiscount(),
                product.getDiscountedPrice());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
        System.out.println("Deleted!");
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @Validated @RequestBody ProductDTO productDTO){
        Product product = productService.findById(id);

        product.setName(productDTO.getName());
        product.setRegularPrice(productDTO.getRegularPrice());
        product.setCategory(productDTO.getCategory());
        product.setDescription(productDTO.getDescription());
        product.setDiscount(productDTO.getDiscount());
        product.setDiscountedPrice(productDTO.getDiscountedPrice());
    }
}
