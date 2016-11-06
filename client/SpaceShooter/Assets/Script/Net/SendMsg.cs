using UnityEngine;
using System.Collections;

public class SendMsg{


	static TcpClient tcpClient = new TcpClient();

	static SendMsg instance = null;

	public void connect(){
	
		tcpClient.ConnectServer ();
	}

	public void send(string str){

		tcpClient.SendMsg (str);
	}

	public void exit(){
		tcpClient.exit ();
	}

	private SendMsg()
	{
	}
	
	public static SendMsg Instance
	{
		get
		{
			if (instance==null)
			{
				instance = new SendMsg();
			}
			return instance;
		}
	}
}
