package com.edneyosf.shelled

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

/**
 * @author Edney O. S. Filho
 *
 * Thread utility class continuously reading from an InputStream
 */

class StreamGobbler() : Thread() {

  private lateinit var reader: BufferedReader
  private lateinit var writer: ArrayList<String>
  private var listener: OnLineListener? = null

  /**
   * <p>StreamGobbler constructor</p>
   *
   * <p>We use this class because shell STDOUT and STDERR should be read as quickly as possible to prevent a
   * deadlock from occurring, or Process.waitFor() never returning (as the buffer is full, pausing the native
   * process)</p>
   *
   * @param inputStream
   *     InputStream to read from
   * @param outputList
   *     List<String> to write to, or null
   */
  constructor(inputStream: InputStream, outputList: List<String>): this(){
    reader = BufferedReader(InputStreamReader(inputStream))
    writer = ArrayList(outputList)
  }

  /**
   * <p>StreamGobbler constructor</p>
   *
   * <p>We use this class because shell STDOUT and STDERR should be read as quickly as possible to prevent a
   * deadlock from occurring, or Process.waitFor() never returning (as the buffer is full, pausing the native
   * process)</p>
   *
   * @param inputStream
   *     InputStream to read from
   * @param onLineListener
   *     OnLineListener callback
   */
  constructor(inputStream: InputStream, onLineListener: OnLineListener): this() {
    reader = BufferedReader(InputStreamReader(inputStream))
    listener = onLineListener
  }

  override fun run() {
    // keep reading the InputStream until it ends (or an error occurs)
    try {
      var line = reader.readLine()

      while (line != null) {

        writer.add(line)
        listener?.onLine(line)

        line = reader.readLine()
      }
    } catch (_ : Exception) { /*reader probably closed, expected exit condition*/ }

    // make sure our stream is closed and resources will be freed
    try { reader.close() } catch (_ : IOException) { }
  }

  /**
   * Line callback interface
   */
  interface OnLineListener {

    /**
     * <p>Line callback</p>
     *
     * <p>This callback should process the line as quickly as possible. Delays in this callback may pause the
     * native process or even result in a deadlock</p>
     *
     * @param line
     *     String that was gobbled
     */
    fun onLine(line: String)
  }
}