package scalaExercise.chap03

import scala.collection.mutable.ArrayBuffer
import scala.util.Random


object Scala3_1 {

  def main(args: Array[String]): Unit = {
    makeArr(10).foreach(println);
    ArrayBuffer()
  }
  
  def makeArr(n: Int): Array[Int] = {
    val a = new Array[Int](n);
    val rand = new Random();
    for(i <- a) yield rand.nextInt();
  }
}