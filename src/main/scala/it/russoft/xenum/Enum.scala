package it.russoft.xenum

/**
  * Generic enumeration definition.
  * This class abstracts new enumeration concepts
  * that simplifies serializations.
  */
abstract class Enum {

  /**
    * Represents the enumeration value model.
    * @param enum The `Enum` reference object.
    * @param value The real value.
    */
  case class EnumVal(enum: Enum, ordinal: Int, value: String) extends Ordered[EnumVal] {
    override def compare(that: EnumVal): Int = ordinal compareTo that.ordinal
    override def toString: String = value
  }

  private var vs: List[_ <: EnumVal] = List()

  /**
    * Helper method to add a new `Enum#EnumVal` entry
    * for this `Enum` object.
    * @param s The value to store into new `Enum#EnumVal` entry.
    * @return Returns just added `Enum#EnumVal` entry.
    */
  protected def value(s: String): EnumVal = {
    val v = EnumVal(this, vs.length, s)
    vs = vs :+ v
    v
  }

  /**
    * Returns the enumeration values.
    * @return Returns a `List[_ <: EnumVal]` object.
    */
  def values: List[_ <: EnumVal] = vs

  /**
    * Returns the enumeration value that corresponds
    * to the supplied value.
    * @param s The value to search in `Enum#EnumVal`s
    * @return Returns `Enum#EnumVal` instance that contains `s` value.
    */
  def withName(s: String): EnumVal = {
    vs.find(_.value == s) match {
      case s: Some[EnumVal] => s.get
      case None => throw new IllegalArgumentException
    }
  }
}