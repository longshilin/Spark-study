package scalaExercise.chap04

import scala.io.Source
import scala.collection.immutable.SortedMap

object scala4_4 {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("./src/main/resources/myFile.txt").mkString
    val tokens = source.split("\\s+")
    var map = SortedMap[String, Int]() // 使用已排序的映射，以便单词可以按顺序打印出来
    for (key <- tokens) {
      map += (key -> (map.getOrElse(key, 0) + 1))
    }
    println(map.mkString(","))
  }
}