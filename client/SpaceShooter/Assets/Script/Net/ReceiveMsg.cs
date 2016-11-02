using UnityEngine;
using System.Collections;
using LitJson;
using System.Collections.Generic;
public class ReceiveMsg{
	

	public void receive(string msgInfo){
		Debug.Log (msgInfo);


		//MessageHandler handler = DictionaryManager.Instance.getMessageHandler ();

		

		try{

			JsonData jsonData = JsonMapper.ToObject(msgInfo);

			Debug.Log(jsonData["score"]+"="+jsonData["handlerNumber"]);
//			JsonData data = new JsonData();
//			
//			data["name"] = "peiandsky";
//			
//			data["age"] = 28;
//			
//			data["sex"] ="male";
//			
//			string  json1= data.ToJson();
//			Debug.Log(json1);
//			JsonData jsonData = JsonMapper.ToObject(json1);
//			JsonData jsonData2 = JsonMapper.ToObject(msgInfo.Trim());
//			Debug.Log (jsonData["sex"]);
			//handlerDictonary [1].action ();
			//Debug.Log (jsonData2["cn"]);
		}catch(JsonException ex){

			Debug.Log(ex.ToString());

		}


	}

}
