package com.gmail.shnapi007.query.engine;

import com.gmail.shnapi007.db.ProductStorage;
import com.gmail.shnapi007.model.Product;
import java.util.Set;
import java.util.stream.Collectors;

public class QueryEngine {

  public static Set<Product> findByQ(String q) {

    return ProductStorage.getProducts().stream()
        .filter(p -> p.getBrand().contains(q)
            || p.getColours().contains(q)
            || String.valueOf(p.getPrice()).contains(q))
        .collect(Collectors.toSet());
  }

}
