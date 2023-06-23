package com.shopping.prototyp1.exceptions;

public class NoValidListException extends Exception{

  static final long serialVersionUID = -3387516993124229948L;

  private String userErrorMessage;
  public NoValidListException(String errorMessage, String userErrorMessage) {
    super(errorMessage);
    this.userErrorMessage=userErrorMessage;
  }
  public NoValidListException() {
    super();
  }

  public NoValidListException(String message) {
    super(message);
  }

  public NoValidListException(String message, Throwable cause) {
    super(message, cause);
  }

  public NoValidListException(Throwable cause) {
    super(cause);
  }

  protected NoValidListException(String message, Throwable cause, boolean enableSuppression, boolean     writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
