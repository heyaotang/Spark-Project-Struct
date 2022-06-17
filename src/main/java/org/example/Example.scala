package org.example

import org.apache.spark.sql.SparkSession

object Example {
  def main(args: Array[String]): Unit = {
    if (args.length < 1) {
      System.exit(1)
    }
    val spark: SparkSession = SparkSession.builder().appName("Task1").getOrCreate()
    println(s"${args(0)}总共有${getLinesCount(spark, args(0))}行数据")
    spark.stop()
  }

  def getLinesCount(spark: SparkSession, path: String): Long = {
    spark.sparkContext.textFile(path).count()
  }
}