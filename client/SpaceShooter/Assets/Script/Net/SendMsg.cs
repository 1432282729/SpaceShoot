using UnityEngine;
using System.Collections;

public class SendMsg : MonoBehaviour {


	private static TcpClient tcpClient = new TcpClient();

	public void connect(){
	
		tcpClient.ConnectServer ();
	}

	public void send(string str){

		tcpClient.SendMsg (str);
	}

	public void exit(){
		tcpClient.exit ();
	}

}
