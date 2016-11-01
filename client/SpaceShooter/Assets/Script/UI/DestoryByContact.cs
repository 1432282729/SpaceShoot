using UnityEngine;
using System.Collections;

public class DestoryByContact : MonoBehaviour {

	public GameObject explosion;

	public GameObject playerExplosion;

	public GameController gameController;

	public PlayerController playerController;

	public int scoreValue;

	public GameObject scorePrompt;

	//飘字
	// Use this for initialization
	void Start () {
		GameObject gameControllerObject = GameObject.FindWithTag ("GameController");
		if(gameControllerObject != null){
			gameController = gameControllerObject.GetComponent<GameController>();
		}
		if(gameController == null){
			Debug.Log("Cannot find 'GameController' Scripts");
		}
	}
	
	// Update is called once per frame
	void Update () {
	
	}

	void OnTriggerEnter(Collider other){

		if(other.tag == "Boundary" || other.tag == "Enemy" || other.tag == "BackGround" || other.tag == "BulletEnemy"){

			return;
		}

		if(explosion != null){
			Object explosionObj = Instantiate(explosion, other.transform.position, other.transform.rotation);
			//加分提示
			scorePrompt = GameObject.Instantiate(scorePrompt);
			scorePrompt.transform.position = other.transform.position;

			Destroy(explosionObj, 1);
			Destroy(scorePrompt, 0.5f);
		}

		if(other.tag == "Player"){
			Object playerExplosionObj = Instantiate(playerExplosion, other.transform.position, other.transform.rotation);;
			Destroy(playerExplosionObj, 1);
			gameController.GameOver();
		}


		gameController.AddScore (scoreValue);
		Destroy (other.gameObject);
		Destroy (this.gameObject);

	}


}
