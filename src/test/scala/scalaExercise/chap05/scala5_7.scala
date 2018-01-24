package scalaExercise.chap05

import scala.collection.JavaConversions.propertiesAsScalaMap

object scala5_7 {
  def main(args: Array[String]): Unit = {
    val props:scala.collection.Map[String,String] = System.getProperties()
    val keys = props.keySet
    val keyLengths = for(key <- keys) yield key.length
    val maxKeyLength = keyLengths.max
    
    for(key <- keys){
      print(key)
      print(" " * (maxKeyLength - key.length))
      print(" | ")
      println(props(key))
    }
    
   
  }
}