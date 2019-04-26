
package com.gmail.shnapi007.db;

import com.gmail.shnapi007.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductStorage {

  private static List<Product> products = new ArrayList<>();

  static {
    for (int i = 0; i < 15; i++) {
      products.add(ProductCreator.createProduct());
    }
  }

  public static boolean addProduct(Product product) {
    return products.add(product);
  }

  public static Product getProductById(long id) {
    return (Product) products.stream().filter(p -> p.getId() == id);
  }

  public static List<Product> getProducts() {
    return products;
  }
}

