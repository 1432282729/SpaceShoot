using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class DictionaryManager {



	static Dictionary<int, string> handlerNames = new Dictionary<int, string>();

	static Dictionary<int, MessageHandler> handlerDictonary = new Dictionary<int, MessageHandler>();

	static DictionaryManager instance = null;

	/**
	 * 注册handler 名字
	 **/
	public void registHandlerName(){
		handlerNames.Add (HandlerNumber.ONEPLAYERCOUNT, "OnePlayerGameCountHandler");
		handlerNames.Add (HandlerNumber.MULTIPLAYERCOUNT, "MultiPlayerGameCountHandler");
		handlerNames.Add (HandlerNumber.CALSCORE, "ResCalSoreHandler");
	}

	/**
	 * 加载handler 
	 **/
	public void loadHandlers(){

		registHandlerName ();

		foreach (KeyValuePair<int, string> kvp in handlerNames)
		{
			System.Type type = System.Type.GetType(kvp.Value); 
			if(type == null){
				continue;
			}
			MessageHandler handler = (MessageHandler)type.Assembly.CreateInstance(type.Name);
			handlerDictonary.Add(kvp.Key, handler);
		}

	}

	/**
	 * 获取handler
	 * 
	 **/
	public Dictionary<int, MessageHandler> getHandlerDictonary(){

		return handlerDictonary;
	}

	public MessageHandler getMessageHandler(int handlerNum){

		return handlerDictonary[handlerNum];
	}


	private DictionaryManager()
	{
	}
	
	public static DictionaryManager Instance
	{
		get
		{
			if (instance==null)
			{
				instance = new DictionaryManager();
			}
			return instance;
		}
	}


}









