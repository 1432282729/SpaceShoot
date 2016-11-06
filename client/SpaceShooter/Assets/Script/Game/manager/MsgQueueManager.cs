using System.Collections;
using System;

public class MsgQueueManager {


	static MsgQueueManager instance = null;


	Queue msgQueue = null;

	private MsgQueueManager()
	{
		msgQueue = new Queue ();
	}
	
	public static MsgQueueManager Instance
	{
		get
		{
			if (instance == null)
			{
				instance = new MsgQueueManager();
			}
			return instance;
		}
	}

	public int msgCount(){

		return msgQueue.Count;
	}

	//入队
	public void enqueue(Object obj){

		msgQueue.Enqueue (obj);
	}
	//出队
	public Object dequeue(){
		if(msgCount() < 1){
			return null;
		}
		return msgQueue.Dequeue ();
	}


}













