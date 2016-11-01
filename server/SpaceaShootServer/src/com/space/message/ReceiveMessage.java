package com.space.message;


import java.io.Serializable;

import io.netty.channel.ChannelHandlerContext;

/**
 * 接收消息的结构体.
 * @author Administrator
 *
 */
public class ReceiveMessage implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int id = 0;//消息ID
	
	private Object data = null; //消息内容
	
	private ChannelHandlerContext context = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ChannelHandlerContext getContext() {
		return context;
	}

	public void setContext(ChannelHandlerContext context) {
		this.context = context;
	}
	
}


