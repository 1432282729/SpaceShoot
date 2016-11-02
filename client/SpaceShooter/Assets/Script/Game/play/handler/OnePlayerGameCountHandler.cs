using UnityEngine;
using System.Collections;
using LitJson;

public class OnePlayerGameCountHandler : MessageHandler {

	//处理服务器发下来的消息
	public override void action(){
		
		Debug.Log ("我是OnePlayerGameCountHandler");
		
	}


}
