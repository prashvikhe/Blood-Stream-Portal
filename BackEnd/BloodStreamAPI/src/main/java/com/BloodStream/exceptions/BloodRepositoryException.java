package com.BloodStream.exceptions;

public class BloodRepositoryException extends RuntimeException {
  private static final long serialVersionUID = 17L;
  
  public BloodRepositoryException(String message) {
    super(message);
  }
}
