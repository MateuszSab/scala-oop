import cats.data.State
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import CalendarUtils._

class CalendarSpec extends AnyFlatSpec with should.Matchers {

  "Calendar" should "posses a day, and a day, a task" in {
    val february: Seq[Day] =
      for (num <- (1 to 29))
        yield Day(num, "February")

    val listOfMonths31 = Seq("January", "March", "May", "July", "August", "October", "December")
    val listOfMonths30 = Seq("April", "June", "September", "November")

    val listOfDays31: Seq[Day]  =
      for (month <- listOfMonths31;
           num <- (1 to 31))
      yield Day(num, month)

    val listOfDays30: Seq[Day]  =
      for (month <- listOfMonths30;
           num <- (1 to 30))
      yield Day(num, month)

    val daysInAYear = listOfDays31 ++ february ++ listOfDays30

    val myCalendar =  Calendar(daysInAYear)
    val study = Task("study","13:00", "15:00")
    val workout = Task("workout", "15:00", "16:00")
    val adDay: State[Calendar, Seq[Day]] = for {
      _ <- add(3, "May", study)
      updated <- add(4, "May", workout)
    } yield updated

    val newCalendar = adDay.run(myCalendar).value._1
    val thirdOfMay = newCalendar.chooseADay(3, "May")
    val fourthOfMay = newCalendar.chooseADay(4, "May")
    println(newCalendar.daysWithTasks())

//    thirdOfMay.get.listOfTasks shouldBe List(Task("study","13:00", "15:00"), Task("workout", "15:00", "16:00"))
    thirdOfMay.get.listOfTasks shouldBe List(Task("study","13:00", "15:00"))
  }

}
