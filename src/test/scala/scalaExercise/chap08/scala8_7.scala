package scalaExercise.chap08

import java.awt.{Point => scalaPoint, Rectangle}

object test8_7 extends App{
  val square = new Square(new scalaPoint(1,1),1)
  new Square()
  new Square(1)
}

class Square(point: scalaPoint, width: Int) extends Rectangle(point.x, point.y, width, width) {
  def this() {
    this(new scalaPoint(0, 0), 0)
  }

  def this(width: Int) {
    this(new scalaPoint(0, 0), width)
  }
}