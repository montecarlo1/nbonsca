import scala.collection.mutable
/**
  * Created by ubuneclipse on 3/1/17.
  */
class Selectsort[T <% Ordered[T]] extends Sorter[T]{
  // algorithms provided by subclasses.
  override def sort(buffer: mutable.Buffer[T]): Unit = {
    for(i <- 0 until buffer.length){
          var min = i;
          for(j <- i until buffer.length){
                if(buffer(j) < buffer(min)){
                  min = j;
                }
          }
          swap(buffer, i, min);
    }
  }
}
