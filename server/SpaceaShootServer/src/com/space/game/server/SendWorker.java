package com.space.game.server;

import com.space.message.SendMessage;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

public class SendWorker implements Runnable {
	
	final private ChannelHandlerContext session;
    private SendMessage smsg;
	
    public SendWorker(ChannelHandlerContext session, SendMessage smsg){
    	this.session = session;
        this.smsg = smsg;
        
    }

	@Override
	public void run() {
		if(session == null){
			return;
		}
		byte[] data = smsg.getData();
		int datalength = (data.length + 4);
		ByteBuf byteBuf;
		byteBuf = Unpooled.buffer(datalength);
		byteBuf.writeInt(datalength);
		byteBuf.writeBytes(smsg.getData());
        try {
        	session.writeAndFlush(byteBuf);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
