package com.space.game.player.bean;


import com.space.game.threads.thread.HeartPulseThead;

import io.netty.channel.ChannelHandlerContext;

public class Player {
	
	private int id;
	
	private String name;
	
	private String password;
	
	private String lastLoginTime;
	
	private ChannelHandlerContext context;
	
	private long lastHeartPulseTime;
	
	private boolean heartPulse;//心脏是否跳动
	
	private HeartPulseThead heartPulseThead; //心跳
	
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

	public boolean isHeartPulse() {
		return heartPulse;
	}

	public void setHeartPulse(boolean heartPulse) {
		this.heartPulse = heartPulse;
	}

	public HeartPulseThead getHeartPulseThead() {
		return heartPulseThead;
	}

	public void setHeartPulseThead(HeartPulseThead heartPulseThead) {
		this.heartPulseThead = heartPulseThead;
	}
	
}
