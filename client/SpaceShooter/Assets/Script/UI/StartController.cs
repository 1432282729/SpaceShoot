using UnityEngine;
using System.Collections;
using LitJson;
public class StartController : MonoBehaviour {

	SendMsg sendMsg;

	// Use this for initialization
	void Start () {
		sendMsg = new SendMsg ();
		sendMsg.connect ();
	}

	//继续游戏
	public void ContinueGame(){
		sendMsg.send ("继续游戏");
	}

	//新游戏
	public void NewGame(){
		JsonData data = new JsonData();
		data["msgId"] = 201;
		data["msgInfo"] = "new name 尹彬彬";
		string jsonInfo = data.ToJson();
		sendMsg.send (jsonInfo);
	}


	//退出游戏
	public void QuitGame(){
		#if UNITY_EDITOR
		UnityEditor.EditorApplication.isPlaying = false;
		#else
		Application.Quit();
		#endif

		sendMsg.exit ();
	}


}
