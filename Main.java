package com.company;

//import java.util.logging.Logger;

import org.apache.log4j.Logger;

public class Main implements Runnable{
    private static final Logger log = Logger.getLogger(Main.class);
    private static int ijk = 0;
    public static void main(String[] args) throws InterruptedException {

        if(log.isDebugEnabled())
        {
            log.debug("This is debug:" + 1);
        }
        if(log.isTraceEnabled())
        {
            log.trace("this is trace:" + 2);
        }
        if(log.isInfoEnabled())
        {
            log.info("this is info:" + 3);
        }
        try
        {
            int j=1, i = 0;
            int k = j/i;
        }
        catch(Exception ex)
        {
            log.info("this is exception:" + ex);
        }
        log.debug("debug");
        log.info("information");
        log.info("warning");
        log.error("error message.");
        //Thread.sleep();
        threadMessage("starting...");
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(new Main());
        t1.start();
        threadMessage("waiting the loop...");
        while(t1.isAlive())
        {
            threadMessage("still waiting...");
            try {
                log.debug("debug");
                log.info("information");
                log.info("warning");
                log.error("error message.");
                t1.join(1000);
                log.debug("debug message....");
                Thread.sleep(5000);
                log.error("error....");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long patience = 1000 * 10;
            if(args.length > 0)
            {
                try{
                    patience = Long.parseLong(args[0]) * 1000;
                    log.debug("debug message........");

                    Thread.sleep(3000);
                }catch(NumberFormatException ex)
                {
                    System.err.println("Argument must be an integer...");
                    System.exit(1);
                }

            }
            if((System.currentTimeMillis() - start) > patience)
            {
                threadMessage("tired of waiting...");
                t1.interrupt();
                t1.join(1);
            }
            /*while(true)
            {

                try
                {
                    //ijk ++;
                    log.info("this is info, ijk=" + ijk);
                    Thread.sleep(1000);
                    ++ijk;
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }

            }*/

        }
        threadMessage("Finally!!!");
    }
    static void threadMessage(String message)
    {
        String threadname = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadname, message);
    }
    @Override
    public void run()
    {
        String mima[] = {"kafka", "zeromq","rabbitmq","redis","mysql","openstack;","distributed computing", "machine learning"};
            for(int i=0; i< mima.length; i++)
            {
                try {
                    Thread.sleep(2000);
                    threadMessage(mima[i]);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                    threadMessage("have not been done yet!");
                }

            }


    }
}
