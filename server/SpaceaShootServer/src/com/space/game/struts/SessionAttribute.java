package com.space.game.struts;


import com.space.game.login.bean.Player;

import io.netty.util.AttributeKey;

public class SessionAttribute {
	
	/**
     * 9	玩家
     */
    public static final AttributeKey<Player> PLAYER = AttributeKey.valueOf("player");
}
