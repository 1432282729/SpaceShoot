package com.space.game.login.server;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.space.game.struts.ClientHandlerNumber;
import com.space.game.struts.RequstResult;
import com.space.util.JsonUtil;
import com.space.util.MessageUtil;

import io.netty.channel.ChannelHandlerContext;

public class LoginServer {
	
	public void register(){
		
		
	}
	
	
	public void login(ChannelHandlerContext context, String name, String pwd){
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("handlerNumber", ClientHandlerNumber.ResLoginHandler);
		dataMap.put("result", RequstResult.NOTEXISTNAME);
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
