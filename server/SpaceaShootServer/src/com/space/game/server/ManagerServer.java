package com.space.game.server;

import com.space.game.login.server.LoginServer;
import com.space.game.player.server.PlayerServer;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ManagerServer {
	
	
	public static PlayerServer playerServer = PlayerServer.getInstance();
	public static LoginServer loginServer = LoginServer.getInstance();
	public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	
	
}
