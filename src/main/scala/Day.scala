case class Day(num: Int, month: String, listOfTasks: List[Task] = List.empty[Task]) {

  def show(): Unit = {
    println("assigned tasks: " + s"$listOfTasks")
  }

  override def toString: String = s"$num $month: " + s"${listOfTasks.mkString(",")}"

}
