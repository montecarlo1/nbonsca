/**
 * Created by ubuneclipse on 2/14/17.
 */
public class Runme {
    public static void main(String[] args){
        Storage ss = new Storage();
        ss.getBooks().stream().forEach(System.out::println);
    }
}
