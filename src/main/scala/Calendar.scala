case class Calendar(daysInAYear: Seq[Day]) {

  def chooseADay(num: Int, month: String): Option[Day] = {
    daysInAYear.find(d => d.num == num && d.month == month)
  }

  def daysWithTasks(): Unit = {
    println(daysInAYear.find(d => d.listOfTasks.nonEmpty))
  }
}




