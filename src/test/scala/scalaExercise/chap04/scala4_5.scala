package scalaExercise.chap04

import java.util.TreeMap
import scala.collection.mutable.Map
import scala.collection.JavaConversions.mapAsScalaMap
import scala.io.Source

object scala4_5 {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("./src/main/resources/myFile.txt").mkString
    val tokens = source.split("\\s+")
    val map:Map[String,Int] = new TreeMap[String,Int] // 使用已排序的映射，以便单词可以按顺序打印出来
    for (key <- tokens) {
      map(key) = map.getOrElse(key, 0) + 1
    }
    println(map.mkString(","))
  }
}