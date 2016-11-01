package com.space.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class HandlerPool  extends ThreadPoolExecutor {
	
	
    public HandlerPool(String name, int corePoolSize, int maxQueueSize)
    {
        super(corePoolSize, 2 * corePoolSize, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

    }
    
    public void addTask(Runnable t){
    	//执行
    	execute(t);
    }
    
}
