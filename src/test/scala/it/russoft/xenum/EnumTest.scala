package it.russoft.xenum

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/**
  * Tests [[Enum]] object.
  */
class EnumTest extends AnyFlatSpec with Matchers {

  //
  // defining new enumeration type
  //
  object Fruit extends Enum {
    type FruitType = EnumVal

    val Apple: FruitType = value("APPLE")
    val Banana: FruitType = value("BANANA")
    val Apricot: FruitType = value("APRICOT")
  }

  //
  // ordinal
  //
  "Fruit.Apple.ordinal" should "be equal to 0" in {
    Fruit.Apple.ordinal shouldEqual 0
  }

  "Fruit.Banana.ordinal" should "be equal to 1" in {
    Fruit.Banana.ordinal shouldEqual 1
  }

  "Fruit.Apricot.ordinal" should "be equal to 2" in {
    Fruit.Apricot.ordinal shouldEqual 2
  }

  //
  // values order
  //
  "Fruit.values.head" should "be equal to Fruit.Apple" in {
    Fruit.values.head shouldEqual Fruit.Apple
  }

  "Fruit.values(1)" should "be equal to Fruit.Banana" in {
    Fruit.values(1) shouldEqual Fruit.Banana
  }

  "Fruit.values(2)" should "be equal to Fruit.Apricot" in {
    Fruit.values(2) shouldEqual Fruit.Apricot
  }

  //
  // values comparing
  //
  "Fruit.Apple" should "not be less than Fruit.Apple" in {
    Fruit.Apple < Fruit.Apple shouldEqual false
  }

  "Fruit.Apple" should "be less than or equal to Fruit.Apple" in {
    Fruit.Apple <= Fruit.Apple shouldEqual true
  }

  "Fruit.Apple" should "be less than or equal to Fruit.Banana" in {
    Fruit.Apple <= Fruit.Banana shouldEqual true
  }

  "Fruit.Apple" should "be less than Fruit.Banana" in {
    Fruit.Apple < Fruit.Banana shouldEqual true
  }

  "Fruit.Banana" should "not be greater than Fruit.Banana" in {
    Fruit.Banana > Fruit.Banana shouldEqual false
  }

  "Fruit.Apricot" should "be greater than Fruit.Banana" in {
    Fruit.Apricot > Fruit.Banana shouldEqual true
  }

  "Fruit.Apricot" should "be greater than or equal to Fruit.Banana" in {
    Fruit.Apricot >= Fruit.Banana shouldEqual true
  }

  "Fruit.Apricot" should "should be greater than or equal to Fruit.Apricot" in {
    Fruit.Apricot >= Fruit.Apricot shouldEqual true
  }

  //
  // cardinality
  //
  "Fruit enum" should "should have three values" in {
    Fruit.values.length shouldEqual 3
  }

  //
  // type
  //
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

  //
  // accessors
  //
  "APPLE name" should "corresponds to Fruit.Apple" in {
    Fruit.withName("APPLE") shouldEqual Fruit.Apple
  }

  "INVALID name" should "throw exception" in {
    an[IllegalArgumentException] should be thrownBy Fruit.withName("INVALID")
  }

  "INVALID name" should "corresponds to None" in {
    Fruit.withNameOpt("INVALID") shouldEqual None
  }

}
