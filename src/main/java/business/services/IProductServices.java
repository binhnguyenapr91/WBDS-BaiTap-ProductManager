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

    @Override
    public void addProduct(Integer id, Product product) {
        ProductRepository.getInstance().add(id,product);
    }

    @Override
    public void deleteProduct(Integer id) {
        ProductRepository.getInstance().delete(id);
    }

    @Override
    public void updateProduct(Integer id, Product product) {
        ProductRepository.getInstance().update(id,product);
    }
}
