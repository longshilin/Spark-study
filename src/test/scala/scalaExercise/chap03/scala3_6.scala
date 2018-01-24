package scalaExercise.chap03

import scala.collection.mutable.ArrayBuffer

object scala3_6 {
  def main(args: Array[String]): Unit = {
    val a = Array(1, -2, 0, -3, 0, 4, 5)
    revertArray(a);
    println(a.mkString(" "))
    
    // ArrayBuffer Reverse
    val b = ArrayBuffer(1, -2, 0, -3, 0, 4, 5)
    val c = ArrayBuffer[Int]()
    c ++= b.reverse
    println(c.mkString(" "))
  }

  def revertArray(a: Array[Int]) = {
    for(i <- 0 until (a.length / 2)){
      val t = a(i)
      a(i) = a(a.length - 1 - i)
      a(a.length - 1 - i) = t
    }
  }

}