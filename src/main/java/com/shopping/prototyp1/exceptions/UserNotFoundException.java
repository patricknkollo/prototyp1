package com.shopping.prototyp1.exceptions;

public class UserNotFoundException extends Exception{

  static final long serialVersionUID = -3387516993124229968L;

  private String userErrorMessage;
  public UserNotFoundException(String errorMessage, String userErrorMessage) {
    super(errorMessage);
    this.userErrorMessage=userErrorMessage;
  }
  public UserNotFoundException() {
    super();
  }

  public UserNotFoundException(String message) {
    super(message);
  }

  public UserNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public UserNotFoundException(Throwable cause) {
    super(cause);
  }

  protected UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean     writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
