package com.saltatorv.notification.manager.domain.exception;

import com.saltatorv.notification.manager.domain.Generated;

public class DeliveryAttemptLimitExceededException extends DomainException {
  private final static String MESSAGE = "Maximum number of attempts reached. Can not send this attempt.";

  @Generated
  @Override
  public String getReason() {
    return MESSAGE;
  }
}
