package ccp.repository.api.controller;

import ccp.repository.api.entities.Product;
import ccp.repository.api.Exception.ProductNotFoundException;
import ccp.repository.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/Inventory")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    // 獲取所有產品
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 創建產品
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // 獲取特定產品
    @GetMapping("/products/{id}")
    public Optional<Product> getProduct(@PathVariable Long id) {
        return productRepository.findById(id);
    }

    // 更新產品
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productData) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setProductName(productData.getProductName());
            product.setQuantity(productData.getQuantity());
            return productRepository.save(product);
        } else {
            throw new ProductNotFoundException(id);
        }
    }

    // 刪除產品
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
