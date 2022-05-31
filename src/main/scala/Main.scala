object Main extends App {

  val myCalendar = new Calendar
  val thirdOfMay = Day(3, "May", 2022)
  val study = Task("study", (13, 15))

  myCalendar.add(thirdOfMay)
  thirdOfMay.add(study)

  myCalendar.show
  thirdOfMay.show
  study.show

}
