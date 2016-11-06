package com.space.game.login.server;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.space.game.player.bean.Player;
import com.space.game.server.ManagerServer;
import com.space.game.struts.ClientHandlerNumber;
import com.space.game.struts.RequstResult;
import com.space.game.struts.SessionAttribute;
import com.space.util.JsonUtil;
import com.space.util.MessageUtil;

import io.netty.channel.ChannelHandlerContext;

public class LoginServer {
	
	private static final Logger logger = Logger.getLogger(LoginServer.class);
	
	public void login(ChannelHandlerContext context, String name, String pwd){
		Player player = null;
		int result = 0;
		//先去内存中查找
		player = ManagerServer.playerServer.getPlayerInCache(context);
		//进入数据库中查找
		logger.info("player="+player);
		if(player == null){
			player = ManagerServer.playerServer.getPlayerByNameInDb(name);
			if(player == null){
				result = RequstResult.NOTEXISTNAME;
			}else if(player != null && !player.getPassword().equals(pwd)){
				result = RequstResult.ERRORPASSWORD;
			}else{
				result = RequstResult.LOGINSUCCESS;
				player.setContext(context);
				context.attr(SessionAttribute.PLAYER).set(player);
			}
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("handlerNumber", ClientHandlerNumber.ResLoginHandler);
		dataMap.put("result", result);
		JSONObject dataJson = JsonUtil.parseObjectToJsonObject(dataMap);
		MessageUtil.sentMsg(context, dataJson);
		
	}
	
	
	private LoginServer()
    {
		
    }
    
    public static LoginServer getInstance()
    {
        return Singleton.INSTANCE.getServer();
    }

    private enum Singleton
    {
        INSTANCE;

    	LoginServer server;

        Singleton()
        {
            this.server = new LoginServer();
        }

        LoginServer getServer()
        {
            return server;
        }
    }
	
}
