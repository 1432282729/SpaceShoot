package com.space.game.server;

import com.space.game.login.server.LoginServer;
import com.space.game.player.server.PlayerServer;

public class ManagerServer {
	
	public static LoginServer loginServer = LoginServer.getInstance();
	public static PlayerServer playerServer = PlayerServer.getInstance();
}
