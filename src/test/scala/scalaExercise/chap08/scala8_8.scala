package scalaExercise.chap08

object test8_8 extends App{
  new Person("elon")
  
  new SecretAgent("secret")
  println("test111s")
}

class Person(val name: String) {
  override def toString = getClass.getName + "[name=" + name + "]"
}

class SecretAgent(codename: String) extends Person(codename) {
  override val name = "secret"
  override val toString = "secret"
}