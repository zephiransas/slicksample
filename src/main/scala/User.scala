import org.joda.time.LocalDate
import scala.slick.driver.H2Driver.simple._
import com.github.tototoshi.slick.JodaSupport._

object User extends Table[(Int, String, Option[LocalDate])]("USERS") {
  def id = column[Int]("id", O.PrimaryKey)
  def name = column[String]("name")
  def birthday = column[Option[LocalDate]]("birthday")
  def * = id ~ name ~ birthday
}