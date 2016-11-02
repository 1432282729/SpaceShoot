package com.space.net;

import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.space.message.ReceiveMessage;
import com.space.message.SendMessage;
import com.space.util.JsonUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;

public class NetMessageCode  extends ByteToMessageCodec<SendMessage> {
	
	private static final Logger logger = Logger.getLogger(NetMessageCode.class);

	@Override
	protected void encode(ChannelHandlerContext ctx, SendMessage smsg,
			ByteBuf out) throws Exception {
		logger.info("encode");
	}
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf buf,
			List<Object> out) throws Exception {
		int msgLength = buf.readableBytes();
		if(msgLength < 1){
			return;
		}
		
		int length = buf.readInt();
		if(length < 1){
			logger.error("当前Session 发上来的数据异常！ " + ctx + "发送了一个空包");
			return;
		}
		//byte[] data = buf.readBytes(buf.readableBytes()).array() ;	
		byte[] data = new byte[buf.readableBytes()];
        buf.readBytes(data);
        String msgText = new String(data, "UTF-8");
        JSONObject jsonObj = JsonUtil.parseStringToJsonObject(msgText);
		Object msgId = jsonObj.get("msgId");
		if(msgId == null){
			logger.error("数据错误格式错误，msgId--->" + msgId);
			return;
		}
		ReceiveMessage rmsg =  new ReceiveMessage();
		rmsg.setId(Integer.parseInt(msgId.toString()));
		rmsg.setData(jsonObj);
		rmsg.setContext(ctx);
		out.add(rmsg);
	}

	
	
}