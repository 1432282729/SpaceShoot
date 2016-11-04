using System;
public abstract class MessageHandler{
	
	private Object msgData; // 待处理的消息

	public abstract void action();

	public Object MsgData{
		get{
			return this.msgData;
		}
		set{
			this.msgData = value;
		}

	}

}
