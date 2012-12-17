package org.diveintojee.poc

import util.parsing.combinator.RegexParsers
/**
 * @author louis.gueye@gmail.com
 */
object QueryParser extends RegexParsers{

  def clauses: Parser[List[String]] = {
    rep1("""\w""".r)
  }

  def parse(input: String) : List[String] = parseAll(clauses, input) match {
    case Success(result, _) => result
    case failure : NoSuccess => scala.sys.error(failure.msg)
  }

}
