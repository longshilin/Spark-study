package scalaExercise.chap04

import scala.io.Source
import scala.collection.mutable.HashMap

object scala4_2 {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("./src/main/resources/myFile.txt").mkString
    val tokens = source.split("\\s+")
    val map = new HashMap[String, Int]
    for(key <- tokens){
      map(key) = map.getOrElse(key, 0) + 1
    }
    println(map.mkString(","))
  }
}