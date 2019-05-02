
package com.gmail.shnapi007.db;

import com.gmail.shnapi007.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductStorage {

  private static List<Product> products = new ArrayList<>();

  static {
    for (int i = 0; i < 20; i++) {
      products.add(ProductCreator.createProduct());
    }
  }

  public static boolean addProduct(Product product) {

    return products.add(product);
  }

  public static Product getProductById(long id) {

    return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
  }

  public static List<Product> getProducts() {

    return products;
  }

  public static boolean removeProduct(long id) {

    return products.remove(getProductById(id));
  }
}

