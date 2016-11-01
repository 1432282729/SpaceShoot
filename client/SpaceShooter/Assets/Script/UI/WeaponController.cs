using UnityEngine;
using System.Collections;

public class WeaponController : MonoBehaviour {

	public GameObject shot;//子弹

	public Transform shotSpwan;//子弹发射位置

	public float delay;

	public float fireRate;//发射率

	// Use this for initialization
	void Start () {
		InvokeRepeating ("Fire", delay, fireRate);//重复发射
	}
	
	// Update is called once per frame
	void Update () {
	
	}

	void Fire(){
		Instantiate (shot, shotSpwan.position, shotSpwan.rotation);
		GetComponent<AudioSource> ().Play ();
	}

}
