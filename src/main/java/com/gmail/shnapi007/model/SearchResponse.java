package com.gmail.shnapi007.model;

import com.google.common.base.MoreObjects;
import java.util.List;
import java.util.Objects;

public class SearchResponse {

  String q;
  List<Product> products;


  public String getQ() {
    return q;
  }

  public void setQ(String q) {
    this.q = q;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchResponse response = (SearchResponse) o;
    return Objects.equals(q, response.q) &&
        Objects.equals(products, response.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(q, products);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("q", q)
        .add("products", products)
        .toString();
  }
}
