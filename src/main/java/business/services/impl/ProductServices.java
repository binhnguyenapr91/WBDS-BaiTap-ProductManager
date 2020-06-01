package business.services.impl;

import business.entities.Product;
import java.util.List;

public interface ProductServices {
    List<Product> getAllProduct();
    Product getProductById(Integer id);
    void addProduct(Integer id,Product product);
    void deleteProduct(Integer id);
    void updateProduct(Integer id,Product product);
}
