package com.gmail.shnapi007.model;

import com.google.common.base.MoreObjects;
import java.util.List;
import java.util.Objects;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

  private long id;
  private long price;
  private String brand;
  private String description;
  private List<String> colours;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<String> getColours() {
    return colours;
  }

  public void setColours(List<String> colours) {
    this.colours = colours;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return id == product.id &&
        price == product.price &&
        Objects.equals(brand, product.brand) &&
        Objects.equals(description, product.description) &&
        Objects.equals(colours, product.colours);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, price, brand, description, colours);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("price", price)
        .add("brand", brand)
        .add("description", description)
        .add("colours", colours)
        .toString();
  }
}
