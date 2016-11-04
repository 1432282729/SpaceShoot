using UnityEngine;
using System.Collections;
using System.Collections.Generic;
public class StartController : MonoBehaviour {

	// Use this for initialization
	void Start () {

		//开始游戏


	}
	

	//单人游戏
	public void OnePlayerGame(){
		Debug.Log ("单人游戏");
		//加载场景
		Application.LoadLevel("Game");
	}

	//多人游戏
	public void MultiPlayerGame(){
		Debug.Log ("多人游戏");
		//发送信息

	}
	//退出游戏
	public void QuitGame(){
		#if UNITY_EDITOR
		UnityEditor.EditorApplication.isPlaying = false;
		#else
		Application.Quit();
		#endif

		SendMsg.Instance.exit ();
	}

	void OnApplicationQuit(){
		Debug.Log ("Over");
		SendMsg.Instance.exit ();
	}

}




