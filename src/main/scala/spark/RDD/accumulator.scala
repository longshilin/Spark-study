package spark.RDD

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object accumulator {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("linecount").setMaster("local")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    val lines = sc.textFile("./src/main/resources/data.txt")
    val blankLines = sc.accumulator(0) // 创建Accumulator[Int]并初始化为0

    val callSigns = lines.flatMap(line => {
      if (line == " ") {
        blankLines += 1
      }
      line.split(" ")
    })

    callSigns.saveAsTextFile("./output")
    callSigns.foreach(println)
    println("Blank lines: " + blankLines.value)
  }
}