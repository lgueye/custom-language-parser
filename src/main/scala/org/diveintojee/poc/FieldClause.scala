package org.diveintojee.poc

/**
 * @author louis.gueye@gmail.com
 */
case class FieldClause(fieldPath: List[String], filter: Filter) extends Clause {
}
