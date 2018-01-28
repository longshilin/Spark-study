package spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext


// 这是一个使用本地变量在local上执行的错误示例
object Localcounter {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("linecount").setMaster("local")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    var counter = 0
    val data = "./src/main/resources/myFile.txt"
    var rdd = sc.parallelize(data)
    
    // Wrong: Don't do this!!
    rdd.foreach(x => counter += x)
    
    println("Counter value: " + counter)
  }
}