using UnityEngine;
using System.Collections;
using System.Net;  
using System; 
using System.Net.Sockets;  
using System.Threading;  
using System.Text; 


public class TcpClient : MonoBehaviour {
	
	private Socket client;
	
	private string msg; 

	private static ReceiveMsg receiveMsg = new ReceiveMsg();

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
		int length = str.Length+4;
		ByteBuffer buf = ByteBuffer.Allocate(length);
		buf.WriteInt (length);
		buf.WriteBytes (Encoding.UTF8.GetBytes (str));
		client.Send (buf.ToArray());
	}
	
	void ReceiveMsg(){
		while(true){

			byte[] disbyte = new byte[1024];
			int msglenth = 0;
			msglenth = client.Receive(disbyte);
			if (msglenth < 1) 
			{  
				Debug.Log("空包");
				continue;
			}
			msg = Encoding.UTF8.GetString(disbyte, 4, msglenth);
			receiveMsg.receive(msg);
		}
	}


	public void exit()  
	{  
		client.Shutdown(SocketShutdown.Both);  
		client.Close();  
	}  
}
