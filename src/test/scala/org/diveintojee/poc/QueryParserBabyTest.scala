package org.diveintojee.poc

import org.junit.Test
import org.junit.Assert._

/**
 * @author louis.gueye@gmail.com
 */
@Test
class QueryParserBabyTest {

  @Test
  def shouldParseSingleClause() {
    val input = "a"
    val result = QueryParserBaby.parse(input)
    assertEquals (Query(List(GlobalClause(KeywordFilter(input)))), result)
  }

  @Test
  def shouldParseMultiClause() {
    val input = "(a|b)"
    val result = QueryParserBaby.parse(input)
    val filter: MultiFilter = MultiFilter(
      List(List(GlobalClause(KeywordFilter("a"))), List(GlobalClause(KeywordFilter("b")))))
    val clause: GlobalClause = GlobalClause(filter)
    assertEquals ( Query(List(clause)), result)
  }

  @Test
  def shouldParseMixedClause() {
    val input = "a (b|c)"
    val result = QueryParserBaby.parse(input)
    val multiClause: GlobalClause = GlobalClause(MultiFilter(List(List(GlobalClause(KeywordFilter("b"))), List(GlobalClause(KeywordFilter("c"))))))
    val globalClause: GlobalClause = GlobalClause(KeywordFilter("a"))
    assertEquals ( Query(List(globalClause, multiClause)) , result)
  }

}
