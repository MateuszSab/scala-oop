import cats.data.State
import java.text.SimpleDateFormat
import scala.annotation.tailrec
import scala.math.Ordered.orderingToOrdered
import scala.io.StdIn.readLine

object CalendarUtils {

  val listOfMonths31 = Seq("January", "March", "May", "July", "August", "October", "December")
  val listOfMonths30 = Seq("April", "June", "September", "November")

  def overlappingOfDates(task1: Task, task2: Task): Boolean = {
    val equal = task1.start == task2.start && task1.end == task2.end
    val intersection = task2.start < task1.end && task1.start < task2.end
    val inclusion1 = task2.start > task1.start && task2.end < task1.end
    val inclusion2 = task1.start > task2.start && task1.end < task2.end
    equal || intersection || inclusion1 || inclusion2
  }


  def add(dayNum: Int, month: String, task: Task): State[Calendar, Seq[Day]] = State { (c: Calendar) =>
    val replaceDay: Seq[Day] = c.daysInAYear.map(d => if (d.num == dayNum && d.month == month) Day(dayNum, month, d.listOfTasks :+ task) else d)
    val newCalendar = c.copy(daysInAYear = replaceDay)
    (newCalendar, newCalendar.daysInAYear)
  }

  @tailrec
  def getRightDecision(): String = {
    val d = readLine("(a)dd task, (s)ee existing tasks, or (q)uit: ").toLowerCase
    if (d =="a") "a"
    else if (d == "s") "s"
    else if (d == "q") "q"
    else {
      println("wrong decision try again")
      getRightDecision()
    }
  }

  @tailrec
  def getRightMoth(): String = {
    val m = readLine("choose month: ").capitalize
    if (listOfMonths31.contains(m) || listOfMonths30.contains(m)) {
      m
    } else {
      println("wrong month choose again")
      getRightMoth()
    }
  }

  @tailrec
  def getRightDay(): Int = {
    val d = readLine("choose a day: ").toInt
    if (d >= 1 && d <= 31) {
      d
    } else {
      println("wrong day number, choose again")
      getRightDay()
    }
  }
  @tailrec
  def getRightEnd(): String = {
    val format = new SimpleDateFormat("HH:mm")
    val d = readLine("choose the end of a task (HH:mm): ")
    try
    {
      format.parse(d)
      d
    }
    catch
      {
        case _ : java.text.ParseException =>
          println("wrong hour format, try again")
          getRightEnd()
      }
  }

  @tailrec
  def getRightBeginning(): String = {
    val format = new SimpleDateFormat("HH:mm")
    val d = readLine("choose the beginning of a task (HH:mm): ")
    try
    {
      format.parse(d)
      d
    }
    catch
    {
      case _ : java.text.ParseException =>
        println("wrong hour format, try again")
        getRightBeginning()
    }
  }

  @tailrec
  def getData(c: Calendar): (Int, String, Task) = {
    val month: String = getRightMoth()
    val day = getRightDay()
    val taskName = readLine("choose task's name: ")
    val beginning = getRightBeginning()
    val end = getRightEnd()

    val takeDay = c.chooseADay(day, month).get
    val task = Task(taskName, beginning, end)
    val overlappingCheck = if (takeDay.listOfTasks.isEmpty) List(false) else takeDay.listOfTasks.map(overlappingOfDates(_, task))
    if (!overlappingCheck.contains(true))
      (day, month, task)
    else {
      println("wrong data, choose again")
      getData(c)
    }
  }

  def updateCalendar(mc: Calendar): Calendar = {
    val data = getData(mc)
    val adDay = add(data._1, data._2, data._3).run(mc)
    adDay.value._1
  }

}
