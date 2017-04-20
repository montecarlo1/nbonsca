import static java.lang.Thread.sleep;

/**
 * Created by ubuneclipse on 2/13/17.
 */
public class Buffer {
    private boolean available = false;
    private int data;
    public synchronized void put(int x){
        while(available){
            try{
                wait();
            } catch(InterruptedException ex){ex.printStackTrace();}
        }
        data = x;
        available = true;
        notify();
    }
    public synchronized int get(){
        while(!available){
            try{
                wait();
            }catch(InterruptedException ex){ex.printStackTrace();}
        }
        available = false;
        notify();
        return data;
    }
}
