import scala.swing._;
/**
  * Created by ubuneclipse on 3/2/17.
  */
object ScalaApp extends SimpleSwingApplication{

      def top = new MainFrame{
           title = "First Swing App"
           contents = new Button {
                 text = "Click me"
           }
      }
  /*def top = new MainFrame{

           title = "First Swing App"
           contents = new Button {
                 text = "Click me"
           }
  }*/
}
