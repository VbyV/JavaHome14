package ru.netology.statistic.JavaHome14;

public class ProductRepository {
    protected Product[] items = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = product;
        items = tmp;

    }

    public void removeById(int id) {
        Product numberId = findById(id);
        if (numberId == null) {
            throw new NotFoundException(
                    "Element with id:" + id + " not found"
            );
        }
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product product : items) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public Product[] getItems() {
        return items;

    }
    public Product findById(int id) {
        for (Product product : items) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}