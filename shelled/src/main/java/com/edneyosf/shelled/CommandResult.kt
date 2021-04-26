package com.edneyosf.shelled;

/**
 * @author Edney O. S. Filho
 *
 * Results of running a command in a shell. Results contain stdout, stderr, and the exit status.
 */
class CommandResult(
  val stdout: List<String> = mutableListOf(),
  val stderr: List<String> = mutableListOf(),
  var exitCode: Int = 0){

  companion object{

    @JvmStatic
    fun toString(lines: List<String>) : String {
      val sb = StringBuilder()
      var emptyOrNewLine = ""

      for (line in lines) {
        sb.append(emptyOrNewLine).append(line)
        emptyOrNewLine = "\n"
      }

      return sb.toString()
    }
  }

  /**
   * Check if the exit code is 0.
   *
   * @return {@code true} if the {@link #exitCode} is equal to {@link ShellExitCode#SUCCESS}.
   */
  fun isSuccessful() = exitCode == ShellExitCode.SUCCESS

  /**
   * Get the standard output.
   *
   * @return The standard output as a string.
   */
  fun stdout() = toString(stdout)

  /**
   * Get the standard error.
   *
   * @return The standard error as a string.
   */
  fun stderr() = toString(stderr)

  override fun toString() = stdout()
}
