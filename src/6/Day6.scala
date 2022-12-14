import scala.io.Source

object Day6 extends App {
  val filename =
    args.find(_ == "--test").fold("input.txt") { _ => "test.input.txt" }

  implicit class RichUnique(val str: String) extends AnyVal {
    def isUnique() = str.distinct == str
  }

  val packets = Source.fromFile(filename).getLines().next

  val window = args.find(_ == "--part2").fold(4)(_ => 14)

  val marker =
    packets.sliding(window).zipWithIndex.find(it => it._1.isUnique).get

  println(marker._2 + window)
}
