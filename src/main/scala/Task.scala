case class Task(title: String, beginning: String, ending: String) {

  import java.text.SimpleDateFormat

  val format = new SimpleDateFormat("HH:mm")
  val start = format.parse(beginning)
  val end = format.parse(ending)

  def show = {
    println("what to do and when: " + s"$title " + "from " + s"${beginning} " + "to " + s"${ending}")
  }

  override def toString: String =
    s"$title " + "from " + s"${beginning} " + "to " + s"${ending}"

}