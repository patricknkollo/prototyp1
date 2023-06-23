package com.shopping.prototyp1.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Component
public class ShippingInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long shippingId;
  private String shippingType;
  private double shippingCost;
  private Long shippingRegionId;

  public ShippingInfo(String shippingType, Long shippingCost, Long shippingRegionId) {
    this.shippingType = shippingType;
    this.shippingCost = shippingCost;
    this.shippingRegionId = shippingRegionId;
  }

  public ShippingInfo() {
  }

  public Long getShippingId() {
    return shippingId;
  }

  public void setShippingId(Long shippingId) {
    this.shippingId = shippingId;
  }

  public String getShippingType() {
    return shippingType;
  }

  public void setShippingType(String shippingType) {
    this.shippingType = shippingType;
  }

  public double getShippingCost() {
    return shippingCost;
  }

  public void setShippingCost(Long shippingCost) {
    this.shippingCost = shippingCost;
  }

  public Long getShippingRegionId() {
    return shippingRegionId;
  }

  public void setShippingRegionId(Long shippingRegionId) {
    this.shippingRegionId = shippingRegionId;
  }

  public void updateShippingInfo(){

  }

  @Override
  public String toString() {
    return "ShippingInfo{" +
        "shippingId=" + shippingId +
        ", shippingType='" + shippingType + '\'' +
        ", shippingCost=" + shippingCost +
        ", shippingRegionId=" + shippingRegionId +
        '}';
  }
}
