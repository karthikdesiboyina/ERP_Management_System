package com.example.erp_management_system.controller;
import com.example.erp_management_system.entity.Product;
import com.example.erp_management_system.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping
    public Product createProduct(
            @RequestBody Product product) {
        return productService.saveProduct(product);
    }
    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }
    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable Long id,
            @RequestBody Product product) {
        product.setProductId(id);
        return productService.saveProduct(product);
    }
    @GetMapping("/count")
    public long getProductCount() {
    return productService.getProductCount();
}
    @DeleteMapping("/{id}")
    public String deleteProduct(
            @PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product Deleted Successfully";
    }
}
