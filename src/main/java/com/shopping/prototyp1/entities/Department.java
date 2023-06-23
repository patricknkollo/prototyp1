package com.shopping.prototyp1.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Component
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long departmentId;
  private String name;
  private  String description;

  public Department(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Department() {
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Long departementId) {
    this.departmentId = departementId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void getCategoryInDepartment(){

  }

  @Override
  public String toString() {
    return "Departement{" +
        "departementId=" + departmentId +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
