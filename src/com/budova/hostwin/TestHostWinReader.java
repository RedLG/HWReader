package com.budova.hostwin;

import com.budova.hostwin.task.SingleGasMeterDbfReaderTask;
import it.sauronsoftware.cron4j.Scheduler;


public class TestHostWinReader {

    public static void main(String[] args) {
        Scheduler s = new Scheduler();
        while (true)
        {
            new SingleGasMeterDbfReaderTask(60000, "C:\\Users\\Dudos\\Downloads\\mgnov.dbf",11481).start();
//            s.schedule("* * * * *", new Runnable() {
////            public void run() {
////                new SingleGasMeterDbfReaderTask(60000, "C:\\mgnov.dbf").start();
////            }
////        });
    }

            }
}
