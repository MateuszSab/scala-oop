import CalendarUtils._

object Main extends App {

  val february: Seq[Day] =
    for (num <- 1 to 29)
      yield Day(num, "February")

  val listOfMonths31 = Seq("January", "March", "May", "July", "August", "October", "December")
  val listOfMonths30 = Seq("April", "June", "September", "November")

  val listOfDays31: Seq[Day] =
    for (month <- listOfMonths31;
         num <- 1 to 31)
    yield Day(num, month)

  val listOfDays30: Seq[Day] =
    for (month <- listOfMonths30;
         num <- 1 to 30)
    yield Day(num, month)

  val daysInAYear = listOfDays31 ++ february ++ listOfDays30

  val myCalendar = Calendar(daysInAYear)

  val data = getData(myCalendar)

  val adDay = add(data._1, data._2, data._3).run(myCalendar)
  val newCalendar = adDay.value._1
  val thirdOfMay = newCalendar.chooseADay(3, "May")


  thirdOfMay.get.show
  newCalendar.daysWithTasks()
}
