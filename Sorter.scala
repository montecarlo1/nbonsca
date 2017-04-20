/**
  * Created by ubuneclipse on 3/1/17.
  */
import scala.math.Ordered;
import scala.collection.mutable.Buffer;
abstract class Sorter[T <% Ordered[T]]{
       // algorithms provided by subclasses.
       def sort(buffer: Buffer[T]):Unit
       //check if the buffer is sorted.
       def sorted(buffer : Buffer[T]) = buffer.isEmpty || buffer.view.zip(buffer.tail).forall{ t => t._2 > t._1}
       // swap elements in buffer
       def swap(buffer : Buffer[T], i:Int, j:Int) {
           val temp = buffer(i)
           buffer(i) = buffer(j)
           buffer(j) = temp
  }
}