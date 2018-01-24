package scalaExercise.chap08

import scala.collection.mutable.ArrayBuffer

object Item extends App {
  val bundle = new Bundle()

  val item1 = new SimpleItem(12.0, "Hello item1")
  val item2 = new SimpleItem(22.0, "Hello item2")
  val item3 = new SimpleItem(30.0, "Hello item3")
  val item4 = new SimpleItem(18.0, "Hello item4")
  val item5 = new SimpleItem(10.0, "Hello item5")

  bundle.addItem(item1)
  bundle.addItem(item2)
  bundle.addItem(item3)
  bundle.addItem(item4)
  bundle.addItem(item5)
  
  println(bundle.description())
  println(bundle.price())
}

abstract class Item {
  def price(): Double
  def description(): String

  override def toString(): String = {
    "description: " + description() + " | price: " + price()
  }
}

class SimpleItem(val price: Double, val description: String) extends Item {
}

class Bundle extends Item {
  val items = new ArrayBuffer[Item]()

  def addItem(item: Item): ArrayBuffer[Item] = {
    items += item
  }
  def price(): Double = {
    var total = 0d
    items.foreach(total += _.price())
    total
  }
  def description(): String = {
    items.mkString("\n")
  }
}