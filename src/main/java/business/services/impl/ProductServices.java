package business.services.impl;

import business.entities.Product;
import java.util.List;

public interface ProductServices {
    List<Product> getAllProduct();
    Product getProductById(Integer id);
}
