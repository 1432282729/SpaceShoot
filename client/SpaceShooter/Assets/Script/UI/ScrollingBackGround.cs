﻿using UnityEngine;
using System.Collections;

public class ScrollingBackGround : MonoBehaviour {
	public float mSpeed = 0.1F; 
	// Use this for initialization
	void Start () {


	}
	
	// Update is called once per frame
	void Update () {

		//transform.Translate(Vector3.down * Time.deltaTime * mSpeed); 
		GetComponent<Renderer>().material.mainTextureOffset = new Vector2(0, mSpeed * Time.time);

	}
}
