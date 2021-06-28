package com.target.targetcasestudy

import com.target.targetcasestudy.data.*
import org.junit.Assert
import org.junit.Test

/**
 * Feel free to make modifications to these unit tests! Remember, you have full technical control
 * over the project, so you can use any libraries and testing strategies that see fit.
 */
class CreditCardValidatorTest {
  @Test
  fun `is credit card number valid`() {
    Assert.assertTrue(
      "valid credit card number should yield true",
      validateCreditCard("4532764313441354")
    )
  }

  @Test
  fun `credit card number has sufficient characters`() {
    Assert.assertTrue("credit has sufficient characters", isSufficientCharacters("4532764313441354"))
  }

  @Test
  fun `credit card number too short`() {
    Assert.assertFalse("credit card too short", isSufficientCharacters("45327"))
  }

  @Test
  fun `credit card number too long`() {
    Assert.assertFalse("credit has too many characters", isSufficientCharacters("45327643134413544532764313441354"))
  }

  @Test
  fun `has drop last digit from credit card number`() {
    Assert.assertEquals(dropLastDigitFromCreditCard("4539976741512043"), "453997674151204")
  }

  @Test
  fun `has NOT drop last digit from credit card number`() {
    Assert.assertNotEquals(dropLastDigitFromCreditCard("4539976741512043"), "4539976741512043")
  }

  @Test
  fun `has remaining numbers from credit card reversed`() {
    Assert.assertEquals(reverseRemainingCreditCard("453997674151204"), "402151476799354")
  }

  @Test
  fun `has remaining numbers from credit card Not reversed`() {
    Assert.assertNotEquals(reverseRemainingCreditCard("453997674151204"), "453997674151204")
  }

  @Test
  fun `has numbers after multiply digit in odd digit and minus by nine`() {
    Assert.assertEquals("189976755356158", getNumbersAfterMultiplyNMinus("589986857376554"))
  }

  @Test
  fun `add all remaining numbers`() {
    Assert.assertEquals(getSumOfAllRemainingNumber("189976755356158"), 85)
  }

  @Test
  fun `perform last check with modulo by 10`() {
    Assert.assertTrue(isSumOfCalculationModuloTen(85, "4556737586899855"))
  }




}
