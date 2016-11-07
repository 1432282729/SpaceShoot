using UnityEngine;
using UnityEngine.UI;
using System.Collections;
using LitJson;
public class ResLoginHandler : MessageHandler{

	public override void action(){

		JsonData jsonData = (JsonData)MsgData;
		int result = int.Parse(jsonData["result"].ToString());
		string resStr = getResult (result);
		GameObject gameObj = GameObject.Find ("LoginPrompt");
		Text promptText = gameObj.GetComponent<Text>();
		promptText.text = resStr;
        if (result == RequstResult.LOGINSUCCESS)
        {
            Application.LoadLevel("GameOption");
        }
	}

	public string getResult(int result){
		string str = "";
		switch(result){
            case RequstResult.NOTEXISTNAME:
				str = "<color=red>*提示：账号不存在</color>";
				break;
            case RequstResult.ERRORPASSWORD:
				str = "<color=red>*提示：密码错误</color>";
				break;
            case RequstResult.LOGINSUCCESS:
                str = "";
                break;
			default :
				str = "<color=red>*提示：未知错误</color>";
				break;
		}
		return str;
	}

}
