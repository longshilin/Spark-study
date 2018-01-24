package scalaExercise.chap03

import scala.collection.mutable.ArrayBuffer

object scala3_4 {
  
  def main(args: Array[String]){
    val a = Array(1,2,0,5,-3,0,-6,2,3,8,-1)
    val b = sigNumArr(a)
    println(b.mkString(" "))
  }
  
  def sigNumArr(arr: Array[Int]) = {
    val buf = new ArrayBuffer[Int]()
    buf ++= (for(i <- arr if i > 0) yield i)
    buf ++= (for(i <- arr if i == 0) yield i)
    buf ++= (for(i <- arr if i < 0) yield i)
    buf.toArray
  }
}