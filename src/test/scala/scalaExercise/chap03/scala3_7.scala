package scalaExercise.chap03

import scala.collection.mutable.ArrayBuffer

object scala3_7 {
  def main(args: Array[String]): Unit = {
    // ArrayBuffer distinct
    val a = ArrayBuffer(1, -2, 1, -3, -5, -6, 2, 2, 0)
    val b = ArrayBuffer[Int]()
    b ++= a.distinct 
    println(b.mkString(" "))
  }
}