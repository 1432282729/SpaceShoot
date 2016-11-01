package com.space.script;


import io.netty.channel.ChannelHandlerContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.space.script.care.IScript;
import com.space.script.struts.ScriptEnum;


public class PlayerScript implements IScript {

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return ScriptEnum.PlayerScript;
	}
	
	//测试
	public void palyerPrint(Object obj){
		System.out.println("obj1="+obj);
	}
	
	public void checkLogin(List<Object> objs){
		//判断ctx是否为空，如果不为空，那么就放入player中
		/*ChannelHandlerContext session = (ChannelHandlerContext) objs.get(0);
		long playerId = Long.parseLong(objs.get(1)+"");
		String password = objs.get(2).toString();
		Player player = Manager.playerManager.login(playerId, password);
		player.setIosession(session);
		session.attr(SessionAttribute.PLAYER).set(player);
		
		Map<String,Object> dataMap = new HashMap<>();
		dataMap.put("loginInfo", "登陆成功");
		JSONObject jsonObj = JsonUtils.getJsonInfoByObj(dataMap); 
		//回送消息
		MessageUtils.sentToPlayer(player, jsonObj);
		//插入日志
		System.out.println("玩家："+player.getPlayerId()+"登陆游戏，时间："+TimeUtils.NowToString());*/
	}
	
	
}
