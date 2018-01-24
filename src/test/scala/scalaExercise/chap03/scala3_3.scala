package scalaExercise.chap03

object scala3_3 {
  def main(args: Array[String]): Unit = {
    val a = Array(1, 2, 3, 4, 5)
    val b = revertYield(a)
    //    b.foreach(println)
    print(b.mkString(" "))
  }

  def revertYield(arr: Array[Int]) = {
    for (i <- 0 until (arr.length)) yield {
      if (i < (arr.length - 1) && i % 2 == 0) {
        val t = arr(i)
        arr(i) = arr(i + 1)
        arr(i + 1) = t
      }
      arr(i)
    }
  }
}