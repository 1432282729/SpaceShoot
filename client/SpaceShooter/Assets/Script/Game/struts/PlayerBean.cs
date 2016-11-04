using UnityEngine;
using System.Collections;

public class PlayerBean{


	private string name;

	private string pwd;

	public string Name{
		get{
			return this.name;
		}
		set{
			this.name = value;
		}
	}

	public string Password{
		get{
			return this.pwd;
		}
		set{
			this.pwd = value;
		}
	}


}
