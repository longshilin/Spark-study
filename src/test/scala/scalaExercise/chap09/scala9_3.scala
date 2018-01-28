package scalaExercise.chap09

import scala.io.Source

object scala9_3 extends App{
  Source.fromFile("./src/main/resources/scala.txt").mkString.
  split("\\s+").foreach(arg => if (arg.length() > 6) println(arg))
}