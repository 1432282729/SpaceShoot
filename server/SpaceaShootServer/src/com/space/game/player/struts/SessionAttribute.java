package com.space.game.player.struts;


import com.space.game.player.bean.Player;

import io.netty.util.AttributeKey;

public class SessionAttribute {
	
	/**
     * 9	玩家
     */
    public static final AttributeKey<Player> PLAYER = AttributeKey.valueOf("player");
}
