using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class DelegateTest : MonoBehaviour {



	public delegate void printDelegate(string str);
	public delegate int getValueDelegate(int num);

	Dictionary<string, printDelegate> delegateDic = new Dictionary<string, printDelegate>();

	// Use this for initialization
	void Start () {

		//delegateDic.Add ("main", printTest);
		//Debug.Log (delegateDic.Count);

		//mainTest (delegateDic["main"], "ddddstr");
		//mainTest (printTest, "dddddd");

		//getValueTest (getValue, 120);

		DictionaryManager.Instance.loadHandlers ();

		Dictionary<int, MessageHandler> handlerDictonary = DictionaryManager.Instance.getHandlerDictonary ();

		handlerDictonary [1].action ();
	}

	public void mainTest(printDelegate print, string str){

		print (str);
	}

	public void getValueTest(getValueDelegate value, int n){
		int a = value (n);
		Debug.Log (a);
	}

	public void printTest(string str){

		Debug.Log (str);
	}

	public int getValue(int n){

		return n;
	}



}
