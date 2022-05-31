import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class CalendarSpec extends AnyFlatSpec with should.Matchers {

  "Calendar" should "posses a day, and a day, a task" in {
    val myCalendar = new Calendar
    val thirdOfMay = Day(3, "May", 2022)
    val study = Task("study", (13, 15))
    myCalendar.add(thirdOfMay)
    thirdOfMay.add(study)
    myCalendar.listOfDays shouldBe List(Day(3,"May",2022))
    thirdOfMay.listOfTasks shouldBe List(Task("study",(13,15)))
    study.whatToDo shouldBe "study"
    study.whenToDo shouldBe (13,15)

  }

}
