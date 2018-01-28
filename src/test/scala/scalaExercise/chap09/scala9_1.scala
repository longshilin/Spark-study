package scalaExercise.chap09

import scala.io.Source
import java.io.PrintWriter

object scala9_1 extends App {
  val path = "./src/main/resources/MyFile.txt"
  val reader = Source.fromFile(path).getLines()
  val result = reader.toArray.reverse
  val pw = new PrintWriter("./src/main/resources/scala.txt")
  result.foreach(line => pw.write(line + "\n"))
  pw.close()
}