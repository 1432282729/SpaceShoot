package com.space;


import com.space.game.server.GameServer;
import com.space.util.LogUtil;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogUtil.loadLogConfig();
		
		//启动game 线程
		new Thread(GameServer.getInstance()).start();
	}

}
