package com.gmail.shnapi007.service;

import com.gmail.shnapi007.common.Config;
import com.gmail.shnapi007.db.ProductStorage;
import com.gmail.shnapi007.model.Product;
import com.gmail.shnapi007.query.engine.QueryEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// https://www.mkyong.com/tutorials/jax-rs-tutorials/
@Path("/json")
public class ProductService {

  @GET
  @Path("/products")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getProducts(@QueryParam("q") String q, @QueryParam("count") int count) {

    if (q != null) {
      List<Product> products = new ArrayList(QueryEngine.findByQ(q));
      if (products.size() >= 20) {
        products = products.subList(0, Config.getIntProperty("maxProductCount"));
      }
      return Response.ok(products).build();
    }

    if (count != 0) {
      return Response.ok(ProductStorage.getProducts().subList(0, count)).build();
    }

    return Response
        .ok(ProductStorage.getProducts().subList(0, Config.getIntProperty("maxProductCount")))
        .build();
  }

  @GET
  @Path("/products/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getProduct(@PathParam("id") long id) {

    Product productById = ProductStorage.getProductById(id);
    return Response.status(200).entity(productById).build();
  }

  @POST
  @Path("/products")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createProduct(Product product) {

    product.setId(new Random().nextInt(9999));
    ProductStorage.addProduct(product);
    String result = "Product saved : " + product.getId();
    return Response.status(201).entity(result).build();
  }


  @POST
  @Path("/products/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createProduct(@PathParam("id") long id, Product product) {

    product.setId(id);
    ProductStorage.addProduct(product);
    String result = "Product saved : " + product.getId();
    return Response.status(201).entity(result).build();
  }

  @DELETE
  @Path("/products/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response deleteProduct(@PathParam("id") long id) {

    ProductStorage.removeProduct(id);
    String result = "Product deleted : " + id;
    return Response.status(200).entity(result).build();
  }
}
