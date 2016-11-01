using UnityEngine;
using System.Collections;
using System.Net;  
using System.Net.Sockets;  
using System.Threading;  
using System.Text; 


public class TcpClient : MonoBehaviour {
	
	private Socket client;
	
	private string msg; 

	public void ConnectServer(){
		try {
			client = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp); 
			client.Connect("127.0.0.1",9000);
			Debug.Log("连接服务器成功");
			Thread threadReceive = new Thread(ReceiveMsg);  
			threadReceive.IsBackground = true;  
			threadReceive.Start();  
			
		} catch
		{
			Debug.LogError("连接服务器失败");
			
		}
	}
	
	public void SendMsg(string str){
		byte[] buffer = Encoding.UTF8.GetBytes (str);
		client.Send (buffer);
	}
	
	void ReceiveMsg(){
		byte[] buffer = new byte[1024 * 1024];
		int len = 0;
		while(true){
			len = client.Receive(buffer);
			if (buffer[0] != 1) 
			{  
				msg = Encoding.UTF8.GetString(buffer, 0, len);
				//JsonReader reader = new JsonTextReader(new StringReader(jsonText));
				Debug.Log("len="+len+",msg="+msg);
			}
		}
	}


	public void exit()  
	{  
		client.Shutdown(SocketShutdown.Both);  
		client.Close();  
	}  
}
