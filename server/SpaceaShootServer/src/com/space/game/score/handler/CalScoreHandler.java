package com.space.game.score.handler;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.space.message.MessageHandler;
import com.space.message.ReceiveMessage;
import com.space.util.JsonUtil;
import com.space.util.MessageUtils;

public class CalScoreHandler extends MessageHandler {
	
	private static final Logger logger = Logger.getLogger(CalScoreHandler.class);

	@Override
	public void action() {
		// TODO Auto-generated method stub
		ReceiveMessage rmsg = getMessage();
		//发送消息
		JSONObject jsonObj = (JSONObject) rmsg.getData();
		String score = jsonObj.get("score").toString();
		
		//将得分保存
		
		//然后下发
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("handlerNumber", 10301);
		dataMap.put("score", score);
		JSONObject dataJson = JsonUtil.parseObjectToJsonObject(dataMap);
		MessageUtils.sentMsg(rmsg.getContext(), dataJson);
	}
	
}






