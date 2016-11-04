using UnityEngine;
using System.Collections;
using LitJson;

public class ReqLoginServer {
	

	public static void loginGame(string name, string pwd){

		JsonData data = new JsonData();
		data["msgId"] = 20101;
		data["player"] = name;
		data["pwd"] = pwd;
		string jsonDataStr = data.ToJson();
		Debug.Log ("jsonDataStr"+jsonDataStr);
		SendMsg.Instance.send (jsonDataStr);
	}

}
