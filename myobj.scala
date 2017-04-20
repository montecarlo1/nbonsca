import java.util
import scala.collection.JavaConversions._
import scala.collection.mutable.ArrayBuffer;
import scala.xml._;
import scala.swing._;
/**
  * Created by ubuneclipse on 2/14/17.
  */
object myobj{

       /*def top = new MainFrame{
         title = "First Swing App"
         contents = new Button {
           text = "Click me"
         }
       }*/

       def PatternMachine(node:Node)={
         node match{
           case <persons>{sub_element}</persons>=>println(sub_element)
           case _ => println("no pair")
         }

       }
       PatternMachine(<persons><person><name>bob</name></person></persons>)
       PatternMachine(<persons><person><name>alice</name></person></persons>)
       //random function
       def random(from:Int, until:Int):Int={
         val size = until - from;
         return from + (math.random *size).toInt;
       }
       def getRandomNum(n:Int, from:Int, until:Int):Array[Int]={
         val elements:Array[Int] = new Array[Int](n);
         for(i <- 0 until n){
           elements(i) = random(from, until);
         }
         elements;
       }
       //myfunction
       def myfunction(a:Array[Int]): Unit ={
         val n = a.length;
         for(i <- 0 until (n-1)){
           val j = random(i,n);
           if(i!=j){
             swap(a,i,j);
           }
         }
       }
       def output(a:Array[Int]): Unit ={
         for(v <- a){
           print(v + " ");
         }
         println();
       }
       //val n = 10;
       //val elements:Array[Int] = new Array[Int](n);
       //for(i <- 0 until n){
       // elements(i) = i + 1;
       //}
       //myfunction(elements);
       //val elements2 = getRandomNum(10, 0 , 100)
       //println("before test:");

       //output(elements2);
       //println("After test:");
       //selecttionsort(elements2)
       //output(elements2)
       //
       //selectionsort1  == special
       def selection(number: Array[Int], order: (Int, Int) => Boolean):Unit={
         def mm(m: Int, j: Int):Int = {
             if(j == number.length) m
             else if(order(number(m), number(j))) mm(m, j+1)
             else mm(m, j+1)
         }
         for(i <- 0 until number.length-1; m = mm(i, i+1))
             if (i != m)
             swap(number, m, i);
       }

       //selectionsort2 == normal
       def selecttionsort(number:Array[Int]):Unit={
         for (i <- 0 until number.size - 1)
           swap(number, i, (i + 1 until number.size).foldLeft(i)((currMin, index) =>
             if (number(index) < number(currMin)) index else currMin))
       }
       def swap(number:Array[Int], i:Int, j:Int):Unit={
         val t = number(i);
         number(i) = number(j);
         number(j) = t;
       }


       def Main(args:Array[String]): Unit={
         println("Hello, world!");
         var a = 10;
         var b = 20;
         var c = a + b;
         println(c);
         var d = c + 1;
         if(d == 31){
           println("your age is:" + d);
         }

         //select sort
         val arr1 = Array(2,3,1,8,7,10,9,8);

         val arr3 = ArrayBuffer(2,3,1,8,7,10,9,8,0);
         val buffer3 = new Selectsort[Int];
         buffer3.sort(arr3);
         output(arr3.toArray)
         //assert(buffer3.sorted(arr3))
         val arr2 = Array(2,3,1,8,7,10,9,0,6,4,5);
         println(arr2.mkString("--"));
         selecttionsort(arr2);
         println(arr2.mkString("&"));
         selection(arr1, (a:Int, b:Int) => a > b);


         Array("e","a","b","c","z","y","x").filter(_>"g").foreach(x=> print(x.toUpperCase.mkString(",")));
         println(arr1.mkString("-"));
         implicit val books = new Storage().getBooks;
         filterByAuthor("Jack London").foreach(b => println(b.getName));
         filterByAuthor("Jack London").foreach(b => println(b));

       }
       def filterByAuthor(author: String)(implicit books: util.ArrayList[Book]) = {
           books.filter(book => book.getAuthor == author);
       }
}
