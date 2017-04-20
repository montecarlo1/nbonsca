import java.io._
/**
  * Created by ubuneclipse on 3/3/17.
  */
object Serialize {
  def main(args: Array[String]): Unit = {
        val file = {
          new File("person.out")
        }
        val oout = new ObjectOutputStream(new FileOutputStream(file))
        val person = new Person
        oout.writeObject(person)
        oout.close()


        val oin = new ObjectInputStream(new FileInputStream(file))
        val newPerson = oin.readObject()
        oin.close()
        println(newPerson)
  }
}
