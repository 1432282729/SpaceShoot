package com.space.game.player.bean;

import io.netty.channel.ChannelHandlerContext;

public class Player {
	
	private int id;
	
	private String name;
	
	private String password;
	
	private String lastLoginTime;
	
	private ChannelHandlerContext context;
	
	private long lastHeartPulseTime;
	
	private boolean onLine;//是否在线

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public ChannelHandlerContext getContext() {
		return context;
	}

	public void setContext(ChannelHandlerContext context) {
		this.context = context;
	}

	public long getLastHeartPulseTime() {
		return lastHeartPulseTime;
	}

	public void setLastHeartPulseTime(long lastHeartPulseTime) {
		this.lastHeartPulseTime = lastHeartPulseTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public boolean isOnLine() {
		return onLine;
	}

	public void setOnLine(boolean onLine) {
		this.onLine = onLine;
	}
	

}
