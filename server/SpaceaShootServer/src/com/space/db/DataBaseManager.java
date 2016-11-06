package com.space.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.space.db.game.GameDbServer;
import com.space.message.MessageManager;

public class DataBaseManager {
	
	private static Logger logger = Logger.getLogger(MessageManager.class);
	
	private DataBaseBean gameDBbean = null;
	
	private DataBaseBean logDBbean = null;
	
	public void loadDbConfig() throws Exception{
		
		String filePath = System.getProperty("user.dir") + "/config/db_config.xml";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    File xmlFile = new File(filePath);
	    if(!xmlFile.exists()){
	    	logger.error("配置文件未找到，请检查路径，路径："+filePath);
	    	return;
	    }
	    Document doc = builder.parse(xmlFile);
	    Element configure = doc.getDocumentElement();
	    NodeList children = configure.getChildNodes();
	    for (int i = 0; i < children.getLength(); ++i) {
	        Node child = children.item(i);
	        if (child instanceof Element) {
	            String name = child.getNodeName();
	            switch (name)
	            {
	                case "game-db":
	                	gameDBbean = getDBConfig(child);
	                    break;
	                case "log-db":
	                	logDBbean = getDBConfig(child);
	                    break;
	            }
	        }
	    }
	}
	
	
	private static DataBaseBean getDBConfig(Node node)
	{
	    String url = null, username = null, password = null;
	    NamedNodeMap attributes = node.getAttributes();
	    for (int j = 0; j < attributes.getLength(); ++j)
	    {
	        Node attribute = attributes.item(j);
	        String attName = attribute.getNodeName();
	        String attValue = attribute.getNodeValue();
	        switch (attName)
	        {
	            case "url":
	                url = attValue;
	                break;
	            case "username":
	                username = attValue;
	                break;
	            case "password":
	                password = attValue;
	                break;
	            default:
	                logger.warn("db_config unknow attribute name: [" + attName + "], value: [" + attValue + "]");
	                break;
	        }
	    }
	    if (url == null || url.isEmpty() || username == null || username.isEmpty() || password == null || password.isEmpty())
	    {
	        throw new NullPointerException();
	    }
	    return new DataBaseBean(url, username, password);
	}

	//获取gameSession
	public SqlSession getGameSession(){
		
		SqlSession session = null;
		String configPath = System.getProperty("user.dir") + "/config/mybatis_config.xml";
		
		try {
			session = GameDbServer.getSession(new FileInputStream(configPath), gameDBbean.getProperties());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}
	
	//获取logSession
	
	public SqlSession getLogSession(){
		
		return null;
	}
	
	public DataBaseBean getGameDBbean() {
		return gameDBbean;
	}


	public void setGameDBbean(DataBaseBean gameDBbean) {
		this.gameDBbean = gameDBbean;
	}


	public DataBaseBean getLogDBbean() {
		return logDBbean;
	}


	public void setLogDBbean(DataBaseBean logDBbean) {
		this.logDBbean = logDBbean;
	}

	private enum Singleton
    {
        INSTANCE;
		DataBaseManager processor;

        Singleton()
        {
            this.processor = new DataBaseManager();
        }

        DataBaseManager getDataBaseManager()
        {
            return processor;
        }
    }
	
    public static DataBaseManager getInstance()
    {
        return Singleton.INSTANCE.getDataBaseManager();
    }
	
	
}
