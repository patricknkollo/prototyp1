package com.shopping.prototyp1.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Component
@Entity
public class CartItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long cartItemId;
  private Long productId;
  private int quantity;
  private float uniCoast;
  private float subtotal;

  public CartItem(Long productId, int quantity, float uniCoast, float subtotal) {
    this.productId = productId;
    this.quantity = quantity;
    this.uniCoast = uniCoast;
    this.subtotal = subtotal;
  }

  public CartItem() {
  }

  public Long getCartItemId() {
    return cartItemId;
  }

  public void setCartItemId(Long cartItemId) {
    this.cartItemId = cartItemId;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public float getUniCoast() {
    return uniCoast;
  }

  public void setUniCoast(float uniCoast) {
    this.uniCoast = uniCoast;
  }

  public float getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(float subtotal) {
    this.subtotal = subtotal;
  }

  public void news (int cartId){

  }
  public void calcPrice(){

  }

}
