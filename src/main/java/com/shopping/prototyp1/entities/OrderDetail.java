package com.shopping.prototyp1.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Component
public class OrderDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Long orderId;
  private Long produitId;
  private String productName;
  private int quantity;
  private float uniCoast;
  private float subtotal;

  public OrderDetail(Long produitId, String productName, int quantity, float uniCoast, float subtotal) {
    this.produitId = produitId;
    this.productName = productName;
    this.quantity = quantity;
    this.uniCoast = uniCoast;
    this.subtotal = subtotal;
  }

  public OrderDetail() {
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Long getProduitId() {
    return produitId;
  }

  public void setProduitId(Long produitId) {
    this.produitId = produitId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
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

  public void calcPrice(){

  }

}
