package com.shopping.prototyp1.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Component
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long categoryId;
  private Long departmentId;
  private String categoryName;
  private String description;

  public Category(Long departmentId, String categoryName, String description) {
    this.departmentId = departmentId;
    this.categoryName = categoryName;
    this.description = description;
  }

  public Category() {
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void getProductsInCategory(){

  }

  @Override
  public String toString() {
    return "Category{" +
        "categoryId=" + categoryId +
        ", departmentId=" + departmentId +
        ", categoryName='" + categoryName + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
