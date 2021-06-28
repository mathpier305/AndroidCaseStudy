package com.target.targetcasestudy.data

/**
 * For an explanation of how to validate credit card numbers read:
 *
 * https://www.freeformatter.com/credit-card-number-generator-validator.html#fakeNumbers
 *
 * This contains a breakdown of how this algorithm should work as
 * well as a way to generate fake credit card numbers for testing
 *
 * The structure and signature of this is open to modification, however
 * it *must* include a method, field, etc that returns a [Boolean]
 * indicating if the input is valid or not
 *
 * Additional notes:
 *  * This method does not need to validate the credit card issuer
 *  * This method must validate card number length (13 - 19 digits), but does not
 *    need to validate the length based on the issuer.
 *
 * @param creditCardNumber - credit card number of (13, 19) digits
 * @return true if a credit card number is believed to be valid,
 * otherwise false
 */
fun validateCreditCard(creditCardNumber: String): Boolean {
  if(!isSufficientCharacters(creditCardNumber)){
    return false
  }
  val substring = dropLastDigitFromCreditCard(creditCardNumber)
  val reverseSubstring = reverseRemainingCreditCard(substring)
  val calculationSubstr = getNumbersAfterMultiplyNMinus(reverseSubstring)
  val sumCalculation = getSumOfAllRemainingNumber(calculationSubstr)
  return isSumOfCalculationModuloTen(sumCalculation, creditCardNumber)
}

fun isSufficientCharacters(creditCardNumber: String) : Boolean {
  if((creditCardNumber.length < 13) || (creditCardNumber.length > 19)) {
    return false
  }
  return true
}

fun dropLastDigitFromCreditCard(creditCardNumber: String) : String {
  return creditCardNumber.substring(0, creditCardNumber.length-1)
}

fun reverseRemainingCreditCard(creditCardNumber: String) : String {
  return creditCardNumber.reversed()
}

fun getNumbersAfterMultiplyNMinus(creditCardNumber: String) : String {
  val newCardNumber : StringBuilder = StringBuilder()
  var doubleIt : Int
  for(n in creditCardNumber.indices ) {
    if(n % 2 == 1) {
      newCardNumber.append(creditCardNumber[n])
    } else {
      doubleIt = Integer.parseInt(creditCardNumber[n].toString()) * 2
      if(doubleIt > 9) {
        doubleIt -= 9
      }
      newCardNumber.append(doubleIt)
    }
  }
  return newCardNumber.toString()
}

fun getSumOfAllRemainingNumber(creditCardNumber: String) : Int{
  var sum =0
  creditCardNumber.forEach {
    sum +=Integer.parseInt(it.toString())
  }
  return sum
}

fun isSumOfCalculationModuloTen(sumOfCalculation: Int, realCardNumber: String) : Boolean{
  val lastDigit = Integer.parseInt(realCardNumber.last().toString())
  val minus = sumOfCalculation + lastDigit
  return (minus % 10 == 0)
}
