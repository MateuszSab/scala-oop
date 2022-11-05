import CalendarUtils._
import DaysInYear._

import scala.annotation.tailrec

object Main extends App {

  val myCalendar = Calendar(daysInAYear)

  @tailrec
  def main(c: Calendar): Unit = {

    val decision = getRightDecision()

    decision match {
      case "a" =>
        val newCalendar: Calendar = updateCalendar(c)
        println("Task added. What's next?")
        main(newCalendar)

      case "s" =>
        c.daysWithTasks()
        main(c)

      case "q" => println("Good Bye!")
    }
  }

  main(myCalendar)

}
