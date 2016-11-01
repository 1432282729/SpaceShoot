using UnityEngine;
using System.Collections;

public class RamdomRotator : MonoBehaviour {

	public float tumble;

	// 给陨石赋予初始的转速度
	void Start () {
		GetComponent<Rigidbody> ().angularVelocity = Random.insideUnitSphere * tumble;
	}

}
