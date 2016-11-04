using UnityEngine;
using UnityEngine.UI;
using System.Collections;

public class GameController : MonoBehaviour {

	public GameObject[] hazards;

	public GameObject enemy;

	public Vector3 spwanValues;//随机生成小行星位置

	public int hazardCount;

	public int enemyCount;

	public float spwanWait;

	public float enemyWait;

	public float startWait;

	public float waveWait;

	public Text scoreText;

	public Text reStartText;

	public Text gameOverText;

	private int score;//分数计算

	private bool gameOver;//游戏是否结束

	private bool reStart;//是否重新开始


	// Use this for initialization
	void Start () {

		reStartText.text = "";
		gameOverText.text = "";
		score = 0;
		gameOver = false;
		reStart = false;
		UpdateScore ();
		StartCoroutine (SpwanWave());
		//StartCoroutine (SpwanEnemy());

	}
	
	// Update is called once per frame
	void Update () {
		if(reStart){
			if(Input.GetKeyDown(KeyCode.R)){
				Application.LoadLevel(Application.loadedLevel);
			}
		}
	}

	//产生陨石，敌机
	IEnumerator SpwanWave(){
		yield return new WaitForSeconds (startWait);
		while(true){
			for(int i=0; i<hazardCount; i++){
				GameObject hazard = hazards[Random.Range(0, hazards.Length)];
				Vector3 spwanPosition = new Vector3 (Random.Range(-spwanValues.x, spwanValues.x), spwanValues.y, spwanValues.z);
				Instantiate (hazard, spwanPosition, Quaternion.identity); 
				yield return new WaitForSeconds(spwanWait);
			}
			yield return new WaitForSeconds(waveWait);
			if(gameOver){
				reStartText.text = "R:ReStart";
				reStart = true;
				break;
			}
		}
	}
	//产生敌机，有问题，待调
	IEnumerator SpwanEnemy(){
		yield return new WaitForSeconds (waveWait);
		while(true){
			for(int i=0; i<enemyCount; i++){
				Vector3 enemyPosition = new Vector3 (Random.Range(-spwanValues.x, spwanValues.x), spwanValues.y, spwanValues.z);
				Instantiate (enemy, enemyPosition, Quaternion.identity); 
				yield return new WaitForSeconds(enemyWait);
			}
			yield return new WaitForSeconds(waveWait);
			if(gameOver){
				break;
			}
		}
	}




	public void AddScore(int newScoreValue){
		score += newScoreValue;
		UpdateScore ();
	}

	void UpdateScore(){

		scoreText.text = "Score:" + score;

	}


	public void GameOver(){

		gameOverText.text = "Game Over";
		gameOver = true;

		//发送消息
//		CSGameOver csGameOver = new CSGameOver ();
//		csGameOver.sendMsgtoServer ();

	}


	void OnApplicationQuit(){
		Debug.Log ("Over");
		SendMsg.Instance.exit ();
	}

}






