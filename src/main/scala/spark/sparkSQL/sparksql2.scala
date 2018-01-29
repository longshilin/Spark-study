package spark.sparkSQL

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.hive.HiveContext

case class HappyPerson(handle: String, favouriteBeverage: String)

object sparksql2 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("sparksql").setMaster("local")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    val hiveCtx = new HiveContext(sc)
    import hiveCtx.implicits._ //  ImportType(hiveCtx.implicits)
    val input = hiveCtx.jsonFile("./inputFile")
    // Print the schema
    input.printSchema()
//    Register the input schema RDD
    input.registerTempTable("tweets")
    // 把数据表缓存起来
    hiveCtx.cacheTable("tweets")
    // Select tweets based on the retweetCount
    val topTweets = hiveCtx.sql("SELECT text, retweetCount FROM tweets ORDER BY retweetCount LIMIT 10")
    topTweets.collect().map(println(_))
    val topTweetText = topTweets.map(row => row.getString(0))
    topTweetText.collect().map(println(_))
    val counts = hiveCtx.sql("SELECT retweetCount FROM tweets")
    val count = counts.map(row => row.getLong(0))
    count.collect().map(println(_))

    // Create a person and turn it into a Schema RDD
    val happyPeopleRDD = sc.parallelize(List(HappyPerson("holden", "coffee"))).toDF()
    happyPeopleRDD.registerTempTable("happy_people")
    //    // UDF
    //    hiveCtx.udf.register("strLenScala", (_: String).length)
    //    val tweetLength = hiveCtx.sql("SELECT strLenScala('tweet') FROM tweets LIMIT 10")
    //    tweetLength.collect().map(println(_))
    //    // Two sums at once (crazy town!)
    //    val twoSums = hiveCtx.sql("SELECT SUM(user.favouritesCount), SUM(retweetCount), user.id FROM tweets GROUP BY user.id LIMIT 10")
    //    twoSums.collect().map(println(_))
    //    sc.stop()
  }
}