package org.diveintojee.poc

import org.junit.{Test, Assert}

/**
 * User: louis.gueye@gmail.com
 */
@Test
class QueryParserTest {

  /**
   * Expected:
   * (EmptyClause)
   */
  @Test
  def shouldReturnEmptyClauseWithNullInput() {
    val input = null
    val result = QueryParser.parse(input)
    Assert assertTrue result.isInstanceOf[List[String]]
    Assert assertTrue result.size == 1
    Assert assertTrue result.apply(0).isInstanceOf[String]
  }

  /**
   * Expected:
   * (EmptyClause)
   */
  @Test
  def shouldReturnEmptyClauseWithEmptyInput() {
    val input = ""
    val result = QueryParser.parse(input)
    Assert assertTrue result.isInstanceOf[List[String]]
    Assert assertTrue result.size == 1
    Assert assertTrue result.apply(0).isInstanceOf[String]
  }


}
