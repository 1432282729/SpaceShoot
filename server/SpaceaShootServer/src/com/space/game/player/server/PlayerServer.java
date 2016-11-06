package com.space.game.player.server;

import org.apache.ibatis.session.SqlSession;

import com.space.db.DataBaseManager;
import com.space.game.player.bean.Player;
import com.space.game.struts.SessionAttribute;

import io.netty.channel.ChannelHandlerContext;

public class PlayerServer {
	
	private SqlSession session = null;
	
	public Player getPlayerByNameInDb(String name){
		
		Player player = session.selectOne("Player.getUserByName", name);
		
		return player;
		
	}
	
	public Player getPlayerInCache(ChannelHandlerContext context){
		
		Player player = context.attr(SessionAttribute.PLAYER).get();
		
		return player;
	}
	
	
	private PlayerServer()
    {
		session = DataBaseManager.getInstance().getGameSession();
    }
    
    public static PlayerServer getInstance()
    {
        return Singleton.INSTANCE.getServer();
    }

    private enum Singleton
    {
        INSTANCE;

    	PlayerServer server;

        Singleton()
        {
            this.server = new PlayerServer();
        }

        PlayerServer getServer()
        {
            return server;
        }
    }
}
