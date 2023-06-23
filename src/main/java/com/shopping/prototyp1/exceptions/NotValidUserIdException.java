package com.shopping.prototyp1.exceptions;

public class NotValidUserIdException extends Exception{

  static final long serialVersionUID = -3387516993124229959L;

  private String userErrorMessage;
  public NotValidUserIdException(String errorMessage, String userErrorMessage) {
    super(errorMessage);
    this.userErrorMessage=userErrorMessage;
  }
  public NotValidUserIdException() {
    super();
  }

  public NotValidUserIdException(String message) {
    super(message);
  }

  public NotValidUserIdException(String message, Throwable cause) {
    super(message, cause);
  }

  public NotValidUserIdException(Throwable cause) {
    super(cause);
  }

  protected NotValidUserIdException(String message, Throwable cause, boolean enableSuppression, boolean     writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
