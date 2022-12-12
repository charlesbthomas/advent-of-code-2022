import scala.io.Source

object Day3Solution extends App {
  val filename = "input.txt"

  def score(str: String): Int = {
    "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(str) + 1
  }

  val matchedItems =
    Source.fromFile(filename).getLines().foldLeft(Seq.empty[String]) {
      (accumulator, rucksack) =>
        val container1 = rucksack.substring(0, rucksack.size / 2)
        val container2 = rucksack.substring(rucksack.size / 2)

        container1.find(char => container2.contains(char)).fold(accumulator) {
          item => accumulator :+ item.toString
        }
    }

  println(matchedItems.map(score).sum)
}
