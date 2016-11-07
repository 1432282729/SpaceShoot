using UnityEngine;
using UnityEngine.UI;
using System.Collections;

public class LoginController : MonoBehaviour {

	public InputField nameInputField;

	public InputField pwdInputField;

	public Text promptText;

	// Use this for initialization
	void Start () {
		GameStart.Instance.start ();

	}

	public void Login(){
		string name = nameInputField.text;
		string pwd = pwdInputField.text;
		ReqLoginServer.loginGame (name, pwd);

		//promptText.text = "<color=red>*提示：密码错误</color>";
		//Application.LoadLevel ("Start");
	}

    public void Regist() {

        Debug.Log("注册账号");
    }
	public void Quit(){
		#if UNITY_EDITOR
		UnityEditor.EditorApplication.isPlaying = false;
		#else
		Application.Quit();
		#endif

		//SendMsg.Instance.exit ();
	}
	void OnApplicationQuit(){
		Debug.Log ("Over");
		SendMsg.Instance.exit ();
	}

	void Update(){
		MessageHandler handler = (MessageHandler)MsgQueueManager.Instance.dequeue ();
		if(handler == null){
			return;
		}
		handler.action ();
	}

}















