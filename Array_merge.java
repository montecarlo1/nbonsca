import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
/**
 * Created by ubuneclipse on 2/10/17.
 */
public class Array_merge {
    public Array_merge() throws Exception{
        QueueConsumer consumer = new QueueConsumer("queue");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

        Producer2 producer = new Producer2("queue");

        for (int i = 0; i < 50000000; i++) {
            HashMap message = new HashMap();
            message.put("message number", i);
            producer.sendMessage(message);
            System.out.println("Message Number "+ i +" sent.");
        }

    }
    public static void main(String[] args){
        Buffer b = new Buffer();
        Consumer c = new Consumer(b);
        Producer p = new Producer(b, 50);
        c.start();
        p.start();

        try {
            Array_merge am = new Array_merge();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //Producer2 pp = new Producer2("ubuneclipse");
        //QueueConsumer qc = new QueueConsumer("queue");


        int[] A={1,2,3};
        int[] B={4,5,3};
        String[] C={"coder coder code","coder cpd code","coder dd zz coder coder","coder coder coder coder"};
        String[] D ={"coder coder"};
        //System.out.println("Integer Array A:" + Arrays.toString(A));
        //System.out.println("Integer Array B:" + Arrays.toString(B));
        //System.out.println("Union:" + Arrays.toString(mergeAB(A, B)));
        //findcoder(C);
    }
    public static int[] mergeAB(int[]... arrays){
        int maxSize = 0;
        int counter = 0;
        for(int[] array : arrays){
            maxSize += array.length;
        }
        int[] temp = new int[maxSize];
        for(int[] array : arrays){
            for(int i : array){
                if(!findDouble(temp, counter, i)){
                    temp[counter++] = i;
                }
            }
        }
        //this code explains why the duplicated element is removed in the merge array.
        //int[] result = new int[counter];
        //for(int i = 0; i < counter; i++){
        //   result[i] = temp[i];
        //}
        return temp;
    }
    public static void findcoder(String[] array){
        ArrayList<Recorder> rs = new ArrayList<Recorder>();
        for(int i = 0; i < array.length; i++){
            //transfer the array into string && to lower case.
            String ss = array[i].toString();
            if(ss.contains("coder")){
                int counter = 0;
                int count1 = 0;
                while(ss.indexOf("coder", count1) >= 0 && count1 < ss.length()) {
                    counter++;
                    count1 = ss.indexOf("coder", count1) + 1;
                }
                rs.add(new Recorder(array[i], counter, i));
            }
        }
        //1, loading array data;
        //2, counting the number of the statistics , merge sorting;
        //3, output the array of the result;
        Collections.sort(rs, new Comparator<Recorder>() {
            @Override
            public int compare(Recorder recorder, Recorder t1) {
                if(recorder.getCount() != t1.getCount()) {
                    return t1.getCount() - recorder.getCount();
                }
                else {
                    return recorder.getIndex() - t1.getIndex();
                }
            }
        });
        String[] sorting = new String[rs.size()];
        for(int i = 0; i < rs.size(); i++) {
            System.out.println(rs.get(i).getData());
            String ss = rs.get(i).getData();
            sorting[i] = ss;
        }
    }
    public static boolean findDouble(int[] array, int counter, int value){
        for(int i = 0; i < counter; i++){
            if (array[i] == value){
                return  true;
            }
        }
        return false;
    }
}
class Recorder{
    private String data;
    private int count;
    private int index;
    public Recorder(String  data, int count, int index){
        this.data = data;
        this.count = count;
        this.index = index;
    }
    public String getData()
    {
        return data;
    }
    public int getCount()
    {
        return count;
    }
    public int getIndex()
    {
        return index;
    }
}