package test;

import java.util.HashMap;
import java.util.Map;

import com.space.util.JsonUtil;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

public class HeartThread extends Thread {
	
	private ChannelHandlerContext ctx;
	
	public HeartThread(ChannelHandlerContext ctx) {
		this.ctx = ctx;
		
	}
	
	int count = 0;
	
	@Override
	public void run(){
		
		try {
			
			while(true){
				Thread.sleep(3000);
				count += 3;
				Map<String, Object> dataMap = new HashMap<String, Object>();
		    	dataMap.put("msgId", 20001);
		    	String dataInfo = JsonUtil.parseObjectToJsonString(dataMap);
		        byte[] req = dataInfo.getBytes("UTF-8");
		        ByteBuf hearMessage = Unpooled.buffer(req.length+4);
		        hearMessage.writeInt(req.length);
		        hearMessage.writeBytes(req);
		        ctx.writeAndFlush(hearMessage);
		        if(count > 3){
		        	break;
		        }
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	

}
