using UnityEngine;
using System.Collections;
using LitJson;
public class ReceiveMsg : MonoBehaviour {
	

	public void receive(string msgInfo){
		Debug.Log ("msg="+msgInfo);
		try{
			JsonData data = new JsonData();
			
			data["name"] = "peiandsky";
			
			data["age"] = 28;
			
			data["sex"] ="male";
			
			string  json1= data.ToJson();
			Debug.Log(json1);
			JsonData jsonData = JsonMapper.ToObject(json1);
			JsonData jsonData2 = JsonMapper.ToObject(msgInfo.Trim());
			Debug.Log (jsonData["sex"]);
			//Debug.Log (jsonData2["cn"]);
		}catch{

			Debug.Log("出错");
			
		}


	}

}
