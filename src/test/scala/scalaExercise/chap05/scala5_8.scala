package scalaExercise.chap05

object scala5_8 {
 def main(args: Array[String]): Unit = {
 }
 
 def minmax(values:Array[Int]){
   (values.max, values.min)
 }
 
 def iteqgt(values:Array[Int], v:Int){
   val buf = values.toBuffer
   (values.count(_ < v), values.count(_ == v), values.count(_ > v))
   
   
 }
}