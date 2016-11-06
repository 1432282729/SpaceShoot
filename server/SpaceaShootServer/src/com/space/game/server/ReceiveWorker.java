package com.space.game.server;

import org.apache.log4j.Logger;

import com.space.message.MessageBean;
import com.space.message.MessageManager;
import com.space.message.MessageHandler;
import com.space.message.ReceiveMessage;



public class ReceiveWorker implements Runnable{
	
    private final static Logger logger = Logger.getLogger(ReceiveWorker.class);
    
    private int msgId;
    private ReceiveMessage rmsg;
    
    public ReceiveWorker(int msgId, ReceiveMessage rmsg){
    	this.msgId = msgId;
    	this.rmsg = rmsg;
    }
    
    
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//获取消息字典
			MessageBean messageBean = MessageManager.getInstance().get(msgId);
			MessageHandler handler = messageBean.getHandler().newInstance();
			handler.setMessage(rmsg);
			//处理函数
			handler.action();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
