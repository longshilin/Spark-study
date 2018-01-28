package scalaExercise.chap03

import scala.collection.mutable.ArrayBuffer

object scala3_8 {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, -2, 0, -3, 0, 4, 5);
    val arrBuf = ArrayBuffer(1, -2, 0, -3, 0, 4, 5);
    val time1 = System.currentTimeMillis()
    val a = deleteUnFirstF(arr)
    val time2 = System.currentTimeMillis()
    println(a)
    println("total time :" + (time2 - time1))

    val time3 = System.currentTimeMillis()
    val b = delete1(arrBuf)
    val time4 = System.currentTimeMillis()
    println(b)
    println("total time :" + (time4 - time3))

    val time5 = System.currentTimeMillis()
    val c = delete2(arrBuf)
    val time6 = System.currentTimeMillis()
    println(c)
    println("total time :" + (time6 - time5))

  }

  // 收集负值元素的下标，反序，去掉最后一个下标，然后对每一个下标调用a.remove(i)
  def deleteUnFirstF(arr: Array[Int]) = {
    val indexes = (for (i <- 0 until arr.length if arr(i) < 0) yield i)
    val rights = indexes.reverse.dropRight(1)
    val tmp = arr.toBuffer
    for (index <- rights) tmp.remove(index)
    tmp
  }

  // 传统的打标记的方法，将第一个负数打标记 再逐个删除后面的负数
  def delete1(arr: ArrayBuffer[Int]) = {
    var first = true
    var n = arr.length
    var i = 0
    while (i < n) {
      if (arr(i) >= 0) i += 1
      else {
        if (first) { first = false; i += 1 }
        else { arr.remove(i); n -= 1 }
      }
    }
    arr
  }

  // 首先收集需要保留的下标，然后将元素移动到该去的位置，并截断微端
  def delete2(arr: ArrayBuffer[Int]) = {
    var first = true
    val indexes = for (i <- 0 until arr.length if first || arr(i) >= 0) yield {
      if (arr(i) < 0) first = false
      i
    }
    for (j <- 0 until indexes.length)
      arr(j) = arr(indexes(j))
    arr.trimEnd(arr.length - indexes.length)
    arr
  }
}




