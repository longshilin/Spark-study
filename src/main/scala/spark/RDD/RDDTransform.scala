package spark.RDD

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object RDD {
  def main(args: Array[String]): Unit = {
    // 初始化Spark设置
    val conf = new SparkConf().setAppName("linecount").setMaster("local")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    
    // RDD Transform Operations Example 
    val inputRDD = sc.textFile("./src/main/resources/")
    val errorsRDD = inputRDD.filter(line => line.contains("error"))
    val warningsRDD = inputRDD.filter(line => line.contains("warning"))
    val badlinesRDD = errorsRDD.union(warningsRDD)
    
    // 输出结果
    println(badlinesRDD.collect().mkString("\n"))
  }
}