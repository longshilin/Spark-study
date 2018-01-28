package spark.pairRDD

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object PairLine {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("pairRDD").setMaster("local")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val lines = sc.textFile("./src/main/resources/")

    val piars = lines.map(x => (x.split(" ")(0), x))
    piars.foreach(println)
  }
}
