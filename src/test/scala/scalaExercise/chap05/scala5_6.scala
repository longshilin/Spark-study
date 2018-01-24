package scalaExercise.chap05

import scala.collection.mutable.LinkedHashMap
import java.util.Calendar

object scala5_6 {
  def main(args: Array[String]): Unit = {
    val map = new LinkedHashMap[String, Int]

    map += ("Monday" -> Calendar.MONDAY)
    map += ("Tuesday" -> Calendar.TUESDAY)
    map += ("Wednesday" -> Calendar.WEDNESDAY)
    map += ("Thursday" -> Calendar.THURSDAY)
    map += ("Friday" -> Calendar.FRIDAY)
    map += ("Saturday" -> Calendar.SATURDAY)
    map += ("Sunday" -> Calendar.SUNDAY)
    
    println(map.mkString("\n"))
  }
}