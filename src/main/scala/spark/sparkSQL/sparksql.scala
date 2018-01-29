package spark.sparkSQL

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.hive.HiveContext

object sparksql {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("sparksql").setMaster("local")
    val sc = new SparkContext(conf)

    sc.setLogLevel("ERROR")

    val hiveCtx = new HiveContext(sc)
    val input = hiveCtx.jsonFile("./inputFile")

    //注册输入的SchemaRDD,创建临时表tweets
    input.registerTempTable("tweets")
    hiveCtx.cacheTable("tweets")
    //依据retweetCount(转发计数)选出推文
    val topTweets = hiveCtx.sql("SELECT text, retweetCount FROM tweets ORDER BY retweetCount LIMIT 10")
    
    //    topTweets.collect().map(println(_))
    println(topTweets.collect().mkString("\n"))
  }
}