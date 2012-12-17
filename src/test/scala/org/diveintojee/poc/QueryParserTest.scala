package org.diveintojee.poc

import org.junit.Test
import org.junit.Assert._

/**
 * User: louis.gueye@gmail.com
 */
@Test
class QueryParserTest {

  /**
   * Expected:
   * ("")
   */
  @Test
  def shouldReturnEmptyStringWithEmptyInput() {
    val input = ""
    val result = QueryParser.parse(input)
    assertEquals (result, List(""))
  }

  /**
   */
  @Test
  def shouldReturnListWithSeveralTokens() {
    val input = "a b"
    val result = QueryParser.parse(input)
    assertEquals (result, List("a", "b"))
  }


}
