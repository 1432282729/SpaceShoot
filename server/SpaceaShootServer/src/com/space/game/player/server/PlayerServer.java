package com.space.game.player.server;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.space.db.DataBaseManager;
import com.space.game.player.bean.Player;
import com.space.game.server.ManagerServer;
import com.space.game.struts.SessionAttribute;

import io.netty.channel.ChannelHandlerContext;

public class PlayerServer {
	
	private static final Logger logger = Logger.getLogger(PlayerServer.class);
	
	private SqlSession session = null;
	
	public Player getPlayerByNameInDb(String name){
		
		Player player = session.selectOne("Player.getUserByName", name);
		
		return player;
		
	}
	
	/**
	 * 从缓存中得到玩家数据
	 * @param context
	 * @return
	 */
	public Player getPlayerInCache(ChannelHandlerContext context){
		
		Player player = context.channel().attr(SessionAttribute.PLAYER).get();
		
		return player;
	}
	
	public void playerQuitGame(ChannelHandlerContext context){
		
		logger.info("玩家：" + context.attr(SessionAttribute.PLAYER).get().getName() + " 离开了");
		
		ManagerServer.channelGroup.remove(context.channel());
		
	}
	
	/**
	 * 枚举实现单列
	 */
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
