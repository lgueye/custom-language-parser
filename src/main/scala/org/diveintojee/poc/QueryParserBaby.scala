package org.diveintojee.poc

import util.parsing.combinator.RegexParsers

/**
 * @author louis.gueye@gmail.com
 */
object QueryParserBaby extends RegexParsers{

  /**
   *
   * @return
   */
  def query: Parser[Query] = {
    rep(clause) ^^ (Query(_))
  }

  def clause = {
    singleClause | multiClause
  }

  def multiClause: Parser[Clause] = {
    "(" ~> singleClauses <~ ")" ^^ (MultiClause(_))
  }

  def singleClauses = {
    rep1sep(singleClause, "|")
  }

  def singleClause = {
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

  def filter: Parser[Filter] = keywordFilter ^^ (KeywordFilter(_)) | "(" ~> multiFilter <~ ")" ^^ (MultiFilter(_))

  def keywordFilter = """[\w]+""".r

  def multiFilter = rep1sep(clauses, "|")

  def clauses: Parser[List[Clause]] = rep1(clause)

  def parse(input: String) = parseAll(query, input) match {
    case Success(result, _) => result
    case failure : NoSuccess => scala.sys.error(failure.msg)
  }

}
