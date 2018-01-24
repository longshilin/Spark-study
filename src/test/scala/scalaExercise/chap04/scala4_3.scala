package scalaExercise.chap04

import scala.io.Source

object scala4_3 {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("./src/main/resources/myFile.txt").mkString
    val tokens = source.split("\\s+")
    var map = Map[String, Int]() // 实用不可变映射
    for (key <- tokens) {
      map += (key -> (map.getOrElse(key, 0) + 1))
    }
    println(map.mkString(","))
  }
}