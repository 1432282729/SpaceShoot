using UnityEngine;
using System.Collections;

public class EvasiveManeuver : MonoBehaviour {
	
	public Boundary boundary;

	public float tilt;//倾斜

	public float dodge; //躲闪

	public float smoothing;

	public Vector2 startWait;//开始机动时候的等待时间

	public Vector2 maneuverTime;//机动时间

	public Vector2 maneuverWait;//机动后等待再次机动的时间

	private float curentSpeed;//当前敌机的速度
	private float targetManeuver;//开始机动的目标值

	private Rigidbody rigiObj;
	// Use this for initialization
	void Start () {
		rigiObj = GetComponent<Rigidbody> ();
		curentSpeed = rigiObj.velocity.z;
		StartCoroutine (Evate());
	}
	
	// Update is called once per frame
	void FixedUpdate () {

		float newManeuver = Mathf.MoveTowards (rigiObj.velocity.x, targetManeuver, smoothing * Time.deltaTime);
		rigiObj.velocity = new Vector3 (newManeuver, 0.0f, curentSpeed);
		rigiObj.position = new Vector3 (Mathf.Clamp(rigiObj.position.x, boundary.xMin, boundary.xMax), 0.0f, 
		                                Mathf.Clamp(rigiObj.position.z, boundary.zMin, boundary.zMax));
		GetComponent<Rigidbody> ().rotation = Quaternion.Euler (0, 0, rigiObj.velocity.x * - tilt);

	}

	IEnumerator Evate(){
		yield return new WaitForSeconds(Random.Range(startWait.x, startWait.y));
		while(true){
			targetManeuver = Random.Range(1, dodge) * -Mathf.Sign(transform.position.x);//如果敌机在X轴正方向，就去负值，如果实在负方向，就取正值
			yield return new WaitForSeconds(Random.Range(maneuverWait.x, maneuverWait.y));
			targetManeuver = 0;
			yield return new WaitForSeconds(Random.Range(maneuverWait.x, maneuverWait.y));//等待1到两秒后，再次机动
		}

	}


}




