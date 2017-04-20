/**
  * Created by ubuneclipse on 3/2/17.
  */
import java.sql.{Connection, DriverManager}
object JdbcConn extends App{
     val url = "jdbc:mysql://localhost:3306/mydata"
     val driver = "com.mysql.jdbc.Driver"
     val username = "admin"
     val password = "something"
     var connection: Connection = _
     try{
          Class.forName(driver)
          connection = DriverManager.getConnection(url, username, password)
          val statement = connection.createStatement()
          val string = "select * from mytable"
          val rs = statement.executeQuery(string)
          while(rs.next()){
               //val id = rs.getString("id")
               //val name = rs.getString("name")
               //val email = rs.getString("email")
               val name = rs.getString("name")
               val age = rs.getString("age");
               println("name = %s, age = %s".format(name, age));
          }

     }catch{
          case e:Exception => e.printStackTrace()
     }finally {
          connection.close()
     }
}
