package scalaExercise.chap08

class BankAccount(initialBlance: Double) {
  private var balance = initialBlance
  def deposit(amount: Double): Double = {
    balance += amount
    balance
  }
  def withdraw(amount: Double): Double = {
    balance -= amount
    balance
  }
}

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  override def deposit(amount: Double): Double = {
    super.deposit(amount - 1)
  }
  override def withdraw(amount: Double): Double = {
    super.withdraw(amount + 1)
  }
}

class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  private var num: Int = _

  def earnMonthlyInterst() = {
    num = 3
    super.deposit(1)
  }
  override def deposit(amount: Double):Double = {
    num -= 1
    if(num < 0)
      super.deposit(amount-1)
    else
      super.deposit(amount)
  }
  override def withdraw(amount:Double):Double = {
    num -= 1
    if(num < 0) 
      super.withdraw(amount+1)
    else
      super.withdraw(amount)
  }
}






