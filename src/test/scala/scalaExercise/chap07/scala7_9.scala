package scalaExercise.chap07

import java.lang.System

object scala7_9 extends App{
  var password = Console.readLine()
  
  if(password equals "secret")
    System.out.println("Hello " + System.getProperty("user.name"))
  else
    System.err.println("password error!")
}