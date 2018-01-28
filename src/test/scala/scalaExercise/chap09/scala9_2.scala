package scalaExercise.chap09

import scala.io.Source
import java.io.PrintWriter

object scala9_2 extends App {
  val path = "./src/main/resources/scala.txt"
  val path1 = "./src/main/resources/scala1.txt"
  val reader = Source.fromFile(path).getLines()
  val result = for (t <- reader) yield t.replaceAll("\\t", "\n")
  val pw = new PrintWriter(path1)
  result.foreach(line => pw.write(line + "\n"))
  pw.close()
}