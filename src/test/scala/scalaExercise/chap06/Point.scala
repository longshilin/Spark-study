package scalaExercise.chap06

class Point(x:Int,y:Int){  
  override def toString: String = "x = " + x + " y = " + y
}  
  
object Point extends App{  
  def apply(x:Int,y:Int)={  
    new Point(x,y)  
  }  
  
  val p = Point(1,2)  
  println(p)  
}  
