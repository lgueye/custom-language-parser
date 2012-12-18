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
  def shouldReturnEmptyListWithEmptyInput() {
    val input = ""
    val result = QueryParser.parse(input)
    assertEquals (result, List())
  }

  /**
   */
  @Test
  def shouldReturnListWithAndSemantic() {
    val input = "a b"
    val result = QueryParser.parse(input)
    assertEquals (result, List("a", "b"))
  }

  /**
   */
  @Test
  def shouldReturnListOfListWithOrSemantic() {
    val input = "a (b|c)"
    val result = QueryParser.parse(input)
    assertEquals (result, List(List("a"), List("b", "c")))
  }


}
