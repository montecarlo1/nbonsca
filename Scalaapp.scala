/**
  * Created by ubuneclipse on 2/14/17.
  */
class Scalaapp extends App{
  def Main(args: Array[String]): Unit = {
    implicit  val books = new Storage().getBooks
    myobj.filterByAuthor("Jack London").foreach(b => println(b))
  }
}
