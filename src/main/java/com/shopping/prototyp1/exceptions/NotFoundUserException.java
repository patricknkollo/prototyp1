package com.shopping.prototyp1.exceptions;

public class NotFoundUserException extends Exception{

  static final long serialVersionUID = -3387516993124229958L;

  private String userErrorMessage;
  public NotFoundUserException(String errorMessage, String userErrorMessage) {
    super(errorMessage);
    this.userErrorMessage=userErrorMessage;
  }
  public NotFoundUserException() {
    super();
  }

  public NotFoundUserException(String message) {
    super(message);
  }

  public NotFoundUserException(String message, Throwable cause) {
    super(message, cause);
  }

  public NotFoundUserException(Throwable cause) {
    super(cause);
  }

  protected NotFoundUserException(String message, Throwable cause, boolean enableSuppression, boolean     writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
