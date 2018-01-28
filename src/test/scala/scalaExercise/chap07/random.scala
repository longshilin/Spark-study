
package random {
  package object random {

    var seed: Int = _
    val a = BigDecimal(1664525)
    val b = BigDecimal(1013904223)
    val n = 32

    def nextInt(): Int = {
      val temp = (seed * a + b) % BigDecimal(2).pow(n)
      seed = temp.toInt
      seed
    }

    def nextDouble(): Double = {
      val temp = (seed * a + b) % BigDecimal(2).pow(n)
      seed = temp.toInt
      temp.toDouble
    }
  }
}
