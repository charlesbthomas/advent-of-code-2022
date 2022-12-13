import scala.io.Source
import scala.collection.mutable.Stack

object Day5 extends App {
  val file = Source.fromFile("input.txt").getLines()

  val matrix = file.takeWhile(str => str != "").toArray
  val commands = file.dropWhile(_.head != 'm').toArray

  val stacks = matrix
    .filter(_.forall(s => !Character.isDigit(s)))
    .reverse
    .foldLeft(Array.empty[Stack[String]]) { (accum, line) =>
      val elements = line.split("").grouped(4).toList
      val stax =
        if (accum.isEmpty) Array.fill(elements.size)(Stack.empty[String])
        else accum

      elements.zipWithIndex.foreach { case (str, idx) =>
        val itm = str.take(2).last
        if (itm != " ")
          stax(idx).push(itm)
      }

      stax
    }

  val pattern = "move (.*) from (.*) to (.*)".r
  commands.foreach { case pattern(count, source, dest) =>
    1 to count.toInt foreach { _ =>
      val selectedStack = stacks(source.toInt - 1)
      val destinationStack = stacks(dest.toInt - 1)
      if (selectedStack.nonEmpty)
        destinationStack push selectedStack.pop
    }
  }

  stacks.map(_.top).foreach(print)
  println
}
