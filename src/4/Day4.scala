import scala.io.Source

case class ElfPair(range1: Range, range2: Range, line: String) {
  def contains = {
    (range1 diff range2).isEmpty || (range2 diff range1).isEmpty
  }

  def overlaps = {
    (range1 intersect range2).nonEmpty || (range2 intersect range1).nonEmpty
  }
}

object ElfPair {
  def fromLine(line: String): ElfPair = {
    val Array(range1String, range2String) = line.split(",")
    ElfPair(rangeFromString(range1String), rangeFromString(range2String), line)
  }

  private def rangeFromString(rangeStr: String): Range = {
    val Array(min, max) = rangeStr.split("-")
    Range.inclusive(min.toInt, max.toInt)
  }
}

object Day4 extends App {
  val elfPairs = Source
    .fromFile("input.txt")
    .getLines()
    .toSeq
    .map(ElfPair.fromLine)

  println("Part 1 ========")
  println(
    elfPairs
      .filter(_.contains)
      .size
  )

  println("Part 2 ========")
  println(
    elfPairs
      .filter(_.overlaps)
      .size
  )
}
