class Calendar {

  var listOfDays = List.empty[Day]

  def show = {
    println("days with assignment " + s"$listOfDays")
    true
  }

  def add(day: Day*) = {
    listOfDays = listOfDays ++ day
    true

  }
}
  case class Day(num: Int, month: String, year: Int) {
    val day = num
    val Month = month
    val Year = year

    var listOfTasks = List.empty[Task]

    def show = {
      println("assigned tasks: " + s"$listOfTasks")
      true
    }

    def add(task: Task*) = {
      listOfTasks = listOfTasks ++ task
      true

    }
  }

  case class Task(title: String, when: (Int, Int)) {

    def show = {
      println("what to do and when: " + s"$whatToDo " + "from " + s"${whenToDo._1} " + "to " + s"${whenToDo._2}")
      true
    }

    val whatToDo = title

    val whenToDo = when

  }
