using UnityEngine;
using System.Collections;
using System.Collections.Generic;
using System.Data;
public class HandlerManager {


	static List<HandlerBean> handlerBeans = new List<HandlerBean>();

	static Dictionary<int, MessageHandler> handlerDictonary = new Dictionary<int, MessageHandler>();

	static HandlerManager instance = null;

	/**
	 * 加载handler 名字
	 **/
	public void loadHandlers(){

		string excelPath = Application.dataPath + "/Resources/Excel/MessageHandlers.xlsx";

		DataSet handlerData = ExcelUtil.loadExcel (excelPath);
		DataTable tables = handlerData.Tables [0];

		int rowCount = tables.Rows.Count;

		for(int i=1; i<rowCount; i++){
			HandlerBean handlerBean = new HandlerBean();
			int handlerNumber = int.Parse(tables.Rows[i][0].ToString());
			string handlerClass = tables.Rows[i][1].ToString();
			handlerBean.HandlerNumber = handlerNumber;
			handlerBean.HandlerClass = handlerClass;
			handlerBeans.Add(handlerBean);
		}

	}

	/**
	 * 注册handler 
	 **/
	public void registHandles(){

		loadHandlers ();

		if(handlerBeans.Count < 1){
			return;
		}
		foreach(HandlerBean handlerBean in handlerBeans){
			System.Type type = System.Type.GetType(handlerBean.HandlerClass); 
			MessageHandler handler = (MessageHandler)type.Assembly.CreateInstance(handlerBean.HandlerClass);
			handlerDictonary.Add(handlerBean.HandlerNumber, handler);
		}

	}

	/**
	 * 获取handler
	 * 
	 **/
	public Dictionary<int, MessageHandler> getHandlerDictonary(){

		return handlerDictonary;
	}

	public MessageHandler getMessageHandler(int handlerNumer){

		return handlerDictonary[handlerNumer];
	}


	private HandlerManager()
	{
	}
	
	public static HandlerManager Instance
	{
		get
		{
			if (instance==null)
			{
				instance = new HandlerManager();
			}
			return instance;
		}
	}


}









