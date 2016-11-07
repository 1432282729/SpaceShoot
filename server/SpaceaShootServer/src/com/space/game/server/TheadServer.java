package com.space.game.server;

import com.space.game.threads.thread.HeartPulseThead;

import io.netty.channel.ChannelHandlerContext;

public class TheadServer {
	
	
	//心跳线程(登录一个用户便启动一次)

	
	//关卡线程
	
	/**
     * 用枚举来实现单例
     */
    private enum Singleton {

        INSTANCE;
    	TheadServer processor;

        Singleton() {
            this.processor = new TheadServer();
        }

        TheadServer getProcessor() {
            return processor;
        }
    }
    
    public static TheadServer getInstance() {
        return Singleton.INSTANCE.getProcessor();
    }
	
	
}
