package scalaExercise.chap07

import java.util.{HashMap => JavaHashMap}
import scala.collection.mutable.HashMap

object scala7_6 extends App{
    val map = new JavaHashMap[String,String]()
    map.put("1", "a")
    map.put("2", "b")
    map.put("3", "c")
    
    val smap = new HashMap[String,String]()
    for(key <- map.keySet().toArray()){
      smap += (key.toString() -> map.get(key))
    }
    
    println(smap.mkString("\n"))
}