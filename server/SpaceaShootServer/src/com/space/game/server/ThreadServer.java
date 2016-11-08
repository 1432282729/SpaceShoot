package com.space.game.server;

import com.space.game.threads.thread.HeartPulseThead;

public class ThreadServer {

	
	
	//心跳线程
	public static HeartPulseThead getHeartPulseThead(){
		
		return new HeartPulseThead();
	}
	
	
}
