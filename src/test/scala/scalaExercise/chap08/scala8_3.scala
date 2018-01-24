package scalaExercise.chap08

object Test1 extends App{
  val art = new Art()
  val drawing = new Drawing()
  val cartoon = new Cartoon()
}

class Art {
  println("Art constructor")
}

class Drawing extends Art {
  println("Drawing constructor")
}

class Cartoon extends Drawing {
  println("Cartoon constructor")
}