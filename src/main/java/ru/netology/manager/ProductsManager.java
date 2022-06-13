package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductsRepository;

public class ProductsManager {
    private ProductsRepository repository;

    public ProductsManager(ProductsRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

//    public boolean matches(Product product, String search) {
//        if (product.getName().contains(search)) {
//            return true;
//        } else {
//            return false;
//        }
////         return product.getName().contains(search);
//    }
}
