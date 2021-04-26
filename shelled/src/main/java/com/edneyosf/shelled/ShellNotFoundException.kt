package com.edneyosf.shelled

import java.io.IOException

/**
 * @author Edney O. S. Filho
 *
 * Exception thrown when a shell could not be opened.
 */
class ShellNotFoundException : IOException {

  /**
   * Constructs a new {@code Exception} with the current stack trace and the specified detail message.
   *
   * @param detailMessage
   *     the detail message for this exception.
   */
  constructor(detailMessage: String) : super(detailMessage){
  }

  /**
   * Constructs a new {@code Exception} with the current stack trace and the specified cause.
   *
   * @param message
   *     the detail message for this exception.
   * @param cause
   *     the cause of this exception.
   */
  constructor(message: String, cause: Throwable) : super(message, cause)
}
