package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductsRepository {
    private Product[] products = new Product[0];

    public void save(Product product) {
        for (Product product1 : products) {
            if (product.getId() == product1.getId()) {
                throw new AlreadyExistsException("Элемент с данным id уже существует");
            }
        }
        Product[] tmp = new Product[products.length + 1];

        System.arraycopy(products, 0, tmp, 0, products.length);

        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Элемент с id: " + id + " не найден");
        }
        Product[] tmp = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }
}
