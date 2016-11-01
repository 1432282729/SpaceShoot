package com.space.message;

import com.space.message.MessageHandler;

public class DictionaryBean {
	
	private final int msgId;
	
	private final Class<? extends MessageHandler> handler;
	
	public DictionaryBean(int msgId, Class<? extends MessageHandler> handler)
    {
        this.msgId = msgId;
        this.handler = handler;
    }

	public int getMsgId() {
		return msgId;
	}

	public Class<? extends MessageHandler> getHandler() {
		return handler;
	}
	
}
