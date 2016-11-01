using UnityEngine;
using System.Collections;

[System.Serializable]
public class Boundary
{
	public float xMin;
	
	public float xMax;
	
	public float zMin;
	
	public float zMax;
}


public class PlayerController : MonoBehaviour {


	public float speed;

	public Boundary boundary;

	public GameObject bullet;//子弹的复制体

	public Transform shotSpwan;//子弹的出生位置

	public float fireRate;//子弹的发射率

	private float nextFire;

	private AudioSource[] audioSources;

	// Use this for initialization
	void Start () {

		audioSources = GetComponents<AudioSource> ();
	}

	void Update(){
		if(Input.GetButton("Fire1") && Time.time > nextFire){
			nextFire = Time.time + fireRate;
			Instantiate(bullet, shotSpwan.position, shotSpwan.rotation); //生成一个子弹
			audioSources[0].Play();

		}

	}

	// Update is called once per frame
	void FixedUpdate () {

		float moveHorizontal = Input.GetAxis ("Horizontal");
		float moveVertical = Input.GetAxis ("Vertical");
		Vector3 mpvement = new Vector3 (moveHorizontal, 0.0f, moveVertical);
		Rigidbody rigiObj = GetComponent<Rigidbody> ();
		rigiObj.velocity = mpvement * speed;
		rigiObj.position = new Vector3 (Mathf.Clamp(rigiObj.position.x, boundary.xMin, boundary.xMax), 0.0f, 
		                                Mathf.Clamp(rigiObj.position.z, boundary.zMin, boundary.zMax));


	}
}






