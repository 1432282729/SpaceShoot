package com.space.game.login.struts;


import io.netty.util.AttributeKey;

public class SessionAttribute {
	
	/**
     * 9	玩家
     */
    public static final AttributeKey<Player> PLAYER = AttributeKey.valueOf("player");
}
