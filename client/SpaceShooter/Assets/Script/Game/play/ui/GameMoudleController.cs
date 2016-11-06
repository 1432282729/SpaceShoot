using UnityEngine;
using System.Collections;

public class GameMoudleController : MonoBehaviour {

	// Use this for initialization
	void Start () {
	
	}

    public void OnSinglePlayerGameMoudle() {

        Debug.Log("单人游戏");
    }

    public void OnMutilPlayerGameMoudle() {

        Debug.Log("多人游戏");
    }

    public void OnBreakThroughMoudle() {
        Debug.Log("闯关模式");
    }

}



