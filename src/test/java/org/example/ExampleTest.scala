
package org.example

import org.apache.spark.sql.SparkSession
import org.example.ExampleTest.spark
import org.scalatest._

object ExampleTest {
  val spark: SparkSession = SparkSession.builder().appName("UnitTest").master("local[*]").getOrCreate()
}

class ExampleTest extends FlatSpec with PrivateMethodTester {
  "lines" should ("equals 10") in {
    val result = Example.getLinesCount(spark, "src\\test\\resources\\unit_test\\example.txt")
    assert(result == 10)
  }
}