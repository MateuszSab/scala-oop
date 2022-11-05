object DaysInYear {

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

  val daysInAYear: Seq[Day] = listOfDays31 ++ february ++ listOfDays30
}
