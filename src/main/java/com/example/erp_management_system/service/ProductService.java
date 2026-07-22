package com.example.erp_management_system.service;
import com.example.erp_management_system.entity.Product;
import com.example.erp_management_system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    public long getProductCount() {
    return productRepository.count();
}
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
