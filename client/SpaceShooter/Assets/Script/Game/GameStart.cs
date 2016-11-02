using UnityEngine;
using System.Collections;

public class GameStart {

	static GameStart instance = null;

	// Use this for initialization
	public void start () {

		//加载handler
		DictionaryManager.Instance.loadHandlers ();
		//获取链接
		SendMsg.Instance.connect();
		//
	}


	private GameStart()
	{
	}
	
	public static GameStart Instance
	{
		get
		{
			if (instance==null)
			{
				instance = new GameStart();
			}
			return instance;
		}
	}

}
