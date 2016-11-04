using UnityEngine;
using UnityEngine.UI;
using System.Collections;
using LitJson;
public class ResLoginHandler : MessageHandler{

	public override void action(){

		JsonData jsonData = (JsonData)MsgData;
		string result = jsonData["result"].ToString();
		string resStr = getResult (result);

		GameObject gameObj = GameObject.Find ("LoginPrompt");

		Text promptText = gameObj.GetComponent<Text>();
		promptText.text = resStr;

		Debug.Log ("我是ResLoginHandler"+resStr);
		
	}

	public string getResult(string result){
		string str = "";
		switch(result){
			case "1" :
				str = "<color=red>*提示：账号不存在</color>";
				break;
			case "2" :
				str = "<color=red>*提示：密码错误</color>";
				break;
			case "3" :
				str = "<color=red>*提示：未知错误</color>";
				break;
			case "4" :
				str = "<color=red>*提示：登录成功</color>";
				break;
		}
		return str;
	}

}
