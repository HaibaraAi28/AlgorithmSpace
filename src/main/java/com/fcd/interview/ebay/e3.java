package com.fcd.interview.ebay;

import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

public class e3 {

    ExecutorService executorService = Executors.newFixedThreadPool(2);

    public void run() {
        executorService.submit(() -> {
            for(int i = 1; i < 100; i++) {
                System.out.println("奇数:" + i);
                i+=2;
                LockSupport.park();
//                LockSupport.unpark(t2);
            }
        });

        executorService.submit(() -> {
            for(int i = 2; i < 100; i++) {
                System.out.println("偶数:" +i);
                i+=2;
                LockSupport.park();
//                LockSupport.unpark(t1);
            }
        });

        executorService.execute(this::run);
    }

}
