import org.joda.time.LocalDate
import scala.slick.driver.H2Driver.simple._

import Database.threadLocalSession

object Main {
  def main(args:Array[String]):Unit = {
    Database.forURL("jdbc:h2:mem:test1", driver = "org.h2.Driver") withSession {
      User.ddl.create

      User.insert(1, "hoge", Some(new LocalDate(2013, 4, 10)))
      User.insert(2, "fuga", Some(new LocalDate(2013, 4, 11)))

      //select all
      Query(User) foreach { case (id, name, birthday) =>
        println(id + ":" + name + ":" + birthday)
      }

      val q1 = for{ u <- User if u.name === "hoge" } yield u.name
      q1 foreach println
    }
  }
}