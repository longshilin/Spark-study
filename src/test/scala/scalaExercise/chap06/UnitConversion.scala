package scalaExercise.chap06

abstract class UnitConversion {

  def inchesToCentimeters() {}
  def gallonsToLiters() {}
  def milesToKilometers() {}

}

object InchesToCentimeters extends UnitConversion {
  override def inchesToCentimeters() {}
}

object GallonsToLiters extends UnitConversion {
  override def gallonsToLiters() {}
}

object MilesToKilometers extends UnitConversion {
  override def milesToKilometers() {}
}  
