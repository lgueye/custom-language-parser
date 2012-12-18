package org.diveintojee.poc

import util.parsing.combinator.RegexParsers
/**
 * @author louis.gueye@gmail.com
 */
object QueryParser extends RegexParsers {

  def query: Parser[Query] = {
    rep(clause) ^^ (Query(_))
  }

  def clause = {
    fieldClause | globalClause
  }

  def globalClause = {
    filter ^^ (GlobalClause(_))
  }

  def fieldClause = {
    path ~ ":" ~ filter ^^ {
      case p ~ _ ~ f => FieldClause (p, f)
    }
  }

  def path = {
    rep1sep("""[\w]+""".r, ".")
  }

  def filter: Parser[Filter] = {
    keyword ^^ (KeywordFilter(_)) | "(" ~> multiFilters <~ ")" ^^ (MultiFilter(_))
  }

  def keyword = {
    """[\w]+""".r
  }

  def multiFilters = {
    rep1sep(clauses, "|")
  }

  def clauses: Parser[List[Clause]] = {
    rep1(clause)
  }

  def parse(input: String) = {
    parseAll(query, input) match {
      case Success(result, _) => result
      case failure : NoSuccess => scala.sys.error(failure.msg)
    }
  }

}
