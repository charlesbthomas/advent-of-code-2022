import scala.io.Source

object Day3SolutionPart2 extends App {
  val filename = "input.txt"

  def score(str: String): Int = {
    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(str) + 1
  }

  val itemGroupings = Source.fromFile(filename).getLines().grouped(3)

  val tags = itemGroupings.foldLeft(Seq.empty[String]) { (accumulator, group) =>
    val tag = group(0)
      .find(item => {
        group(1).contains(item) && group(2).contains(item)
      })
      .map(_.toString)
      .toSeq
    accumulator ++ tag
  }

  println(tags.map(score).sum)
}
