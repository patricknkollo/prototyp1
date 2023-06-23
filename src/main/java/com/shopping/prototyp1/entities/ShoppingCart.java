package com.shopping.prototyp1.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Component
public class ShoppingCart {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cartId;
  private Long productId;
  private int quantity;
  private Timestamp dateAdded;


  public void addCartItem(){

  }
  public void deleteCartItem(){

  }
  public void viewCartDetails(){

  }
  public void updatequantity(){

  }
  public void checkout(){

  }
  public void calctotalPrice(){

  }
}
