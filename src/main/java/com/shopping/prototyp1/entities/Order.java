package com.shopping.prototyp1.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Component
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderId;
  private Timestamp dateCreated;
  private Timestamp dateShipped;
  private String customerName;
  private Long customerId;
  private String status;
  private Long shippingId;

  public Order(Timestamp dateCreated, Timestamp dateShipped, String customerName, Long customerId,
      String status, Long shippingId) {
    this.dateCreated = dateCreated;
    this.dateShipped = dateShipped;
    this.customerName = customerName;
    this.customerId = customerId;
    this.status = status;
    this.shippingId = shippingId;
  }

  public Order() {
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Timestamp getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Timestamp dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Timestamp getDateShipped() {
    return dateShipped;
  }

  public void setDateShipped(Timestamp dateShipped) {
    this.dateShipped = dateShipped;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Long getShippingId() {
    return shippingId;
  }

  public void setShippingId(Long shippingId) {
    this.shippingId = shippingId;
  }

  public void placeOrder(){

  }
}
