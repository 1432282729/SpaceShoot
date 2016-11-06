using UnityEngine;
using System.Collections;
using LitJson;
using System.Collections.Generic;
public class ReceiveMsg{
	

	public void receive(string msgInfo){
		try{

			JsonData jsonData = JsonMapper.ToObject(msgInfo);
			int handlerNumber = int.Parse(jsonData["handlerNumber"].ToString());
			MessageHandler handler = HandlerManager.Instance.getMessageHandler(handlerNumber);
			handler.MsgData = jsonData;
			MsgQueueManager.Instance.enqueue(handler);

			//handler.action();

		}catch(JsonException ex){
			Debug.LogError(ex.ToString());

		}
	}

}
