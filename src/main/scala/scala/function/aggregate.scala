package scala.function

/*
 *  scala中的聚合函数aggregate，比folder和reduce更灵活，详见Scala API文档
 */
object aggregate {
  def main(args: Array[String]): Unit = {
    val input = Array(1, 2, 3)
    val result = input.aggregate(0, 0)(
        (acc, value) => (acc._1 + value, acc._2 + 1), 
        (acc1, acc2) => (acc1._1 + acc2._1, acc1._2 + acc2._2))
    val avg = result._1 / result._2.toDouble
    println(avg)
        
    
    val result1 = List('a', 'b', 'c').aggregate(0)({ (sum, ch) => sum + ch.toInt }, { (p1, p2) => p1 + p2 })
    println(result1)
    
  }
}