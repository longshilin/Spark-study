package spark.RDD

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object wordcount {
  def main(args: Array[String]): Unit = {
    val logFile = "hdfs://spark:9000/README.md"
    val localFile = "./src/main/resources/myFile.txt"
    val conf = new SparkConf().setAppName("wordcount").setMaster("local")
    //    conf.set("spark.executor.memory", "512m")
    //    conf.set("spark.driver.memory", "512m")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val logData = sc.textFile(localFile).cache()
    val numAs = logData.filter(line => line.contains("s")).count()
    val numBs = logData.filter(line => line.contains("r")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
  }
}