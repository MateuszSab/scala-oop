case class Day(num: Int, month: String, listOfTasks: List[Task] = List.empty[Task]) {

  def show = {
    println("assigned tasks: " + s"$listOfTasks")
    true
  }
}