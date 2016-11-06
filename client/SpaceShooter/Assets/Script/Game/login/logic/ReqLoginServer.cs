using UnityEngine;
using System.Collections;
using LitJson;

public class ReqLoginServer {
	

	public static void loginGame(string name, string pwd){

		JsonData data = new JsonData();
        data["msgId"] = ServerHandlerNumber.ReqLoginHandler;
        data["name"] = name;
		data["pwd"] = pwd;
		string jsonDataStr = data.ToJson();
		SendMsg.Instance.send (jsonDataStr);
	}

}
