package com.space.message;

import java.io.Serializable;

/**
 * 发送消息的结构体.
 * @author Administrator
 *
 */
public class SendMessage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private byte[] data;

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}











