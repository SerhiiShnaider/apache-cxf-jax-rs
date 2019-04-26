package com.gmail.shnapi007.db;

import com.gmail.shnapi007.model.Product;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProductCreator {

  private static Random random = new Random();
  private static List<String> brands = Arrays
      .asList("Adidas", "nike", "puma", "MERRELL", "MAJESTIC", "MARMOT");
  private static List<String> colours = Arrays
      .asList("Red", "Orange", "Yellow", "Blue", "Green", "Purple", "Brown", "Silver", "Pink",
          "Black", "White", "Grey");

  public static Product createProduct() {
    Product product = new Product();

    product.setId((random.nextInt(99999) + random.nextInt(99999) / 4) * 2);
    product.setBrand(brands.get(random.nextInt(brands.size())));
    product.setColours(getColours());
    product.setPrice(random.nextInt(99999));
    product
        .setDescription(product.getBrand() + " " + product.getColours() + " " + product.getPrice());
    return product;
  }

  private static List<String> getColours() {
    List<String> colours = new ArrayList<>();
    for (int i = 0; i < random.nextInt(4); i++) {
      colours.add(ProductCreator.colours.get(random.nextInt(ProductCreator.colours.size())));
    }
    return colours;
  }
}
