package com.example.frame;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Song Shuyu
 * Created by Administrator on 2019/1/20 0020 11:56
 * Created Sheepss
 * package is com.example.frame
 * TODO
 */
public class AB {
    public  void thread(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
