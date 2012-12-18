package org.diveintojee.poc

/**
 * @author louis.gueye@gmail.com
 */
case class MultiFilter(orClauses: List[List[Clause]]) extends Filter {
}
