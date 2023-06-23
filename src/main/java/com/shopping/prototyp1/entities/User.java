package com.shopping.prototyp1.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Component
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;
  private String password;
  private String loggingStatus;

  public User(String password, String loggingStatus) {
    this.password = password;
    this.loggingStatus = loggingStatus;
  }

  public User() {
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getLoggingStatus() {
    return loggingStatus;
  }

  public void setLoggingStatus(String loggingStatus) {
    this.loggingStatus = loggingStatus;
  }

  public void verifyLogin(){
  }
}
