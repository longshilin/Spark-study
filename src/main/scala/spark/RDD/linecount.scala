package spark.RDD

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object linecount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("linecount").setMaster("local")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val lines = sc.textFile("./src/main/resources/")
    val lineLengths = lines.map(s => s.length()) 
    lineLengths.persist()
    val totalLength = lineLengths.reduce((a, b) => a + b)
    println(totalLength)
  }
}