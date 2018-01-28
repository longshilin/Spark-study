package spark.pairRDD

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object avg {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("pairRDD").setMaster("local")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    //在scala中使用reduceByKey()和mapValues()计算每个键对应的平均值
    val rdd = sc.parallelize(Array(("panda", 0), ("pink", 3), ("pirate", 3), ("panda", 1), ("pink", 4)))
    val reduceRdd = rdd.mapValues(x => (x, 1)).reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2))

    reduceRdd.foreach(println)
    val result = reduceRdd.map { case (key, value) => (key, value._1 / value._2.toFloat) }
    result.foreach(println)

    // combineByKey聚合函数计算每个键对应的平均值
    val result1 = rdd.combineByKey(
      (v) => (v, 1),
      (acc: (Int, Int), v) => (acc._1 + v, acc._2 + 1),
      (acc1: (Int, Int), acc2: (Int, Int)) => (acc1._1 + acc2._1, acc1._2 + acc2._2)
      ).map { case (key, value) => (key, value._1 / value._2.toFloat) }
    result1.foreach(println)
  }
}