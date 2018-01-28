package scalaExercise.chap06

object Card extends Enumeration with App {
  val M = Value("♣")
  val T = Value("♠")
  val H = Value("♥")
  val F = Value("♦")

  println(Card.M + " -> " + (Card.M.id).toString())
  println(Card.T + " -> " + (Card.T.id).toString())
  println(Card.H + " -> " + (Card.H.id).toString())
  println(Card.F + " -> " + (Card.F.id).toString())

  def color(c: Card.Value) {
    if (c == Card.M || c == Card.T) print("Black")
    else print("Red")
  }

  color(Card.H)

}  
