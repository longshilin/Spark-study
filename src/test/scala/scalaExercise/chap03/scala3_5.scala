package scalaExercise.chap03

object scala3_5 {

  def main(args: Array[String]): Unit = {
    val a = Array(1.0, -2.0, 0.0, -3.0, 0.0, 4.0, 5.0)
    val b = avgArr(a)
    println(b)
  }

  def avgArr(a: Array[Double]) = {
    a.sum / a.length
  }
}

