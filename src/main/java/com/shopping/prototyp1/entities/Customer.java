package com.shopping.prototyp1.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Component
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long customerId;
  private String customerName;
  private String address;
  private String email;
  private String phone;
  private String creditCardInfo;
  private String shippingInfo;

  public Customer(String customerName, String address, String email, String phone, String creditCardInfo,
      String shippingInfo) {
    this.customerName = customerName;
    this.address = address;
    this.email = email;
    this.phone = phone;
    this.creditCardInfo = creditCardInfo;
    this.shippingInfo = shippingInfo;
  }

  public Customer() {
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getCreditCardInfo() {
    return creditCardInfo;
  }

  public void setCreditCardInfo(String creditCardInfo) {
    this.creditCardInfo = creditCardInfo;
  }

  public String getShippingInfo() {
    return shippingInfo;
  }

  public void setShippingInfo(String shippingInfo) {
    this.shippingInfo = shippingInfo;
  }

  public void register(){

  }
  public void login(){

  }
  public void updateProfile(){

  }
  public void search(){

  }
}
