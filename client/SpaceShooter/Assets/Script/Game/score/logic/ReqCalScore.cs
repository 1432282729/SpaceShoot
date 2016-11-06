using UnityEngine;
using System.Collections;
using LitJson;
public class ReqCalScore {
	
	static ReqCalScore instance = null;

	public void CalculateScore(string score){
		JsonData data = new JsonData();
        data["msgId"] = ServerHandlerNumber.CalScoreHandler;
		data["score"] = score;
		string msgInfo = data.ToJson();
		SendMsg.Instance.send (msgInfo);
	}




	private ReqCalScore()
	{
	}
	
	public static ReqCalScore Instance
	{
		get
		{
			if (instance==null)
			{
				instance = new ReqCalScore();
			}
			return instance;
		}
	}
}
