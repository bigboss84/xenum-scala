package it.russoft.xenum

import org.scalatest._

/**
  * Tests [[Enum]] object.
  */
class EnumTest extends FlatSpec with Matchers {

  //
  // defining new enumeration type
  //
  object Fruit extends Enum {
    type FruitType = EnumVal

    val Apple: FruitType = value("APPLE")
    val Banana: FruitType = value("BANANA")
    val Apricot: FruitType = value("APRICOT")
  }

  "Fruit enum" should "should have three values" in {
    Fruit.values.length shouldEqual 3
  }

  "Fruit.Apple" should "be instance of Enum#EnumVal" in {
     Fruit.Apple shouldBe a[Enum#EnumVal]
  }

  "Fruit.Apple.enum" should "be instance of Enum" in {
    Fruit.Apple.enum shouldBe a[Enum]
  }

  "Fruit.Apple.enum" should "be instance of Fruit" in {
    Fruit.Apple.enum shouldBe a[Fruit.type]
  }

  "Fruit.Apple.value" should "be APPLE" in {
    Fruit.Apple.value shouldEqual "APPLE"
  }

  "APPLE name" should "corresponds to Fruit.Apple" in {
    Fruit.withName("APPLE") shouldEqual Fruit.Apple
  }

  "INVALID name" should "throw exception" in {
    an[IllegalArgumentException] should be thrownBy Fruit.withName("INVALID")
  }

}
