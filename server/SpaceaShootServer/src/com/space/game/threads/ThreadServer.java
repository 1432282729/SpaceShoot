package com.space.game.threads;

import com.space.game.threads.thread.GamePointThead;
import com.space.game.threads.thread.HeartPulseThead;

public class ThreadServer {

	private HeartPulseThead heartPulseThead;
	
	private GamePointThead gamePointThead;
	
	
	
	//启动所有非子线程
	public void start(){
		
		//心跳线程
		heartPulseThead.start();
		//关卡线程
		gamePointThead.start();
		//boss线程
		
		//精英敌机线程
		
		
	}
	
	
	
	
	private ThreadServer(){
		
		heartPulseThead = new HeartPulseThead();
		
		gamePointThead = new GamePointThead();
	}
	
	public static ThreadServer getInstance()
    {
        return Singleton.INSTANCE.getServer();
    }

    private enum Singleton
    {
        INSTANCE;

    	ThreadServer server;

        Singleton()
        {
            this.server = new ThreadServer();
        }

        ThreadServer getServer()
        {
            return server;
        }
    }
}
