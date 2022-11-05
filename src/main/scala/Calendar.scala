case class Calendar(daysInAYear: Seq[Day]) {

  def chooseADay(num: Int, month: String): Option[Day] = {
    daysInAYear.find(d => d.num == num && d.month == month)
  }

  def daysWithTasks(): Seq[Day] = {
    daysInAYear.filter(d => d.listOfTasks.nonEmpty)
  }

  def show(): Unit = {
    println("what to do and when: ")
    daysWithTasks().foreach(println)
  }
}




