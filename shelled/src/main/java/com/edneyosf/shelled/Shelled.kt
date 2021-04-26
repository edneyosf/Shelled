package com.edneyosf.shelled

/**
 * @author Edney O. S. Filho
 */

object Shelled {

  @JvmStatic
  private fun run(command: String): Result {
    val result: CommandResult = Shell.SU.run(command)

    return Result(result.getStdout(), result.getStderr())
  }

  class Result(private val success: String, val error: String) {

    fun hasError(): Boolean {
      return error != ""
    }

    fun getOutput(): String{ return "success: $success | error: $error" }

    fun get(): String {
      return success
    }
  }
}
