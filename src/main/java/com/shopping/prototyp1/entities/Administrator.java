package com.shopping.prototyp1.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Component
public class Administrator {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long adminId;
  private String adminName;
  private String mail;

  public Administrator(String adminName, String mail) {
    this.adminName = adminName;
    this.mail = mail;
  }

  public Long getAdminId() {
    return adminId;
  }

  public void setAdminId(Long adminId) {
    this.adminId = adminId;
  }

  public String getAdminName() {
    return adminName;
  }

  public void setAdminName(String adminName) {
    this.adminName = adminName;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public Administrator() {
  }

  public void createDepartement(){

  }
  public void createCategorie(){

  }
  public void createProduct(){

  }
  public void deleteDepartement(){

  }
  public void deleteCategorie(){

  }
  public void deleteProduct(){

  }
  public void editCatalogDetails(){

  }
}
