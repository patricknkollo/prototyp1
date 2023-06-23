package com.shopping.prototyp1.exceptions;

public class NoValidUserException extends Exception{

  static final long serialVersionUID = -3387516993124229968L;

  private String userErrorMessage;
  public NoValidUserException(String errorMessage, String userErrorMessage) {
    super(errorMessage);
    this.userErrorMessage=userErrorMessage;
  }
  public NoValidUserException() {
    super();
  }

  public NoValidUserException(String message) {
    super(message);
  }

  public NoValidUserException(String message, Throwable cause) {
    super(message, cause);
  }

  public NoValidUserException(Throwable cause) {
    super(cause);
  }

  protected NoValidUserException(String message, Throwable cause, boolean enableSuppression, boolean     writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
