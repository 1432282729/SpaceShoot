using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class DictionaryManager {



	Dictionary<int, string> handlerNames = new Dictionary<int, string>();

	Dictionary<int, MessageHandler> handlerDictonary = new Dictionary<int, MessageHandler>();

	static DictionaryManager instance = null;

	/**
	 * 注册handler 名字
	 **/
	public void registHandlerName(){
		handlerNames.Add (1, "ClientHandler");
		handlerNames.Add (2, "PlayerHandler");
		
	}

	/**
	 * 加载handler 
	 **/
	public void loadHandlers(){

		registHandlerName ();

		foreach (KeyValuePair<int, string> kvp in handlerNames)
		{
			System.Type type = System.Type.GetType(kvp.Value); 
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









