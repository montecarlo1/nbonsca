/**
  * Created by ubuneclipse on 3/3/17.
  */
@serializable
class Person {
     var name:String = "JVM"
     var age:Int = 3
     override def toString: String = "name="+ name + "," + "age=" + age
}