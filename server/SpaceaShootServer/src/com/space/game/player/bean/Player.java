package com.space.game.player.bean;

import java.util.Date;

import com.space.util.TimeUtil;

import io.netty.channel.ChannelHandlerContext;

public class Player {
	
	private int id;
	
	private String name;
	
	private String password;
	
	private String lastLoginTime = TimeUtil.format2string(new Date().getTime());
	
	private ChannelHandlerContext context;
	
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
}
