package business.services;

import business.entities.Product;
import business.entities.repositories.ProductRepository;
import business.services.impl.ProductServices;

import java.util.List;

public class IProductServices implements ProductServices {

    @Override
    public List<Product> getAllProduct() {
        return ProductRepository.getInstance().getAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return ProductRepository.getInstance().getById(id);
    }
}
