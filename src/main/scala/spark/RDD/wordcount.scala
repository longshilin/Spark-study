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
    val localData = sc.textFile(localFile).cache()
    //    val numAs = localData.filter(line => line.contains("s")).count()
    //    val numBs = localData.filter(line => line.contains("r")).count()
    //    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
    val result = localData.flatMap(line => line.split(" ")).map(x => (x, 1)).reduceByKey((x, y) => x + y)
    result.foreach(println)
    
    println("*********")
    
    val sortedResult = result.sortByKey(true)
    sortedResult.foreach(println)
  }
}