package scalaExercise.chap08

object test9_5 extends App{
  val point = new Point(1,2)
  println(point)
  val labelpoint = new LabelPoint("Hello", 10, 20)
  println(labelpoint)
}

class Point(x:Int, y:Int){
  override def toString(): String = {
    "x: " + x + " | y:" + y
  }
}

class LabelPoint(label:String, x:Int, y:Int) extends Point(x, y){
  label + "123"
  override def toString(): String = {
    "label:" + label + " | x:" + x + " | y:" + y
  }
}