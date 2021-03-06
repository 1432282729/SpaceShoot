package com.space.message;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.space.message.MessageHandler;

public class MessageManager {
	
	private static final Map<Integer, MessageBean> handlerMap = new ConcurrentHashMap<>();
	private static Logger logger = Logger.getLogger(MessageManager.class);
	
	/**
     * 用枚举来实现单例
     */
    private enum Singleton
    {
        INSTANCE;
        MessageManager processor;

        Singleton()
        {
            this.processor = new MessageManager();
        }

        MessageManager getMessageManager()
        {
            return processor;
        }
    }
	
    public static MessageManager getInstance()
    {
        return Singleton.INSTANCE.getMessageManager();
    }
    
	/**
	 * 通过msgid得到handler
	 * @param msgId
	 * @return
	 */
	public MessageBean get(int msgId){
		
		return handlerMap.get(msgId);
		
	}
	
	@SuppressWarnings("rawtypes")
	//加载handler配置
    public synchronized void loadHandlerConfig() throws Exception{
		String filePath = System.getProperty("user.dir") + "/config/handler_config.xml";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		File xmlFile = new File(filePath);
		Document doc = builder.parse(xmlFile);
		Element configure = doc.getDocumentElement();
		NodeList children = configure.getChildNodes();
		
		List<Map<String, String>> nodeMap = new ArrayList<>();
		for(int i=0; i < children.getLength(); i++){
			Node child = children.item(i);
			if (child instanceof Element)
            {
                Map<String, String> mlist = new HashMap<>();
                NamedNodeMap attributes = child.getAttributes();
                for (int j = 0; j < attributes.getLength(); ++j)
                {
                    Node attribute = attributes.item(j);
                    String attName = attribute.getNodeName();
                    String attValue = attribute.getNodeValue();
                    mlist.put(attName, attValue);
                }
                if (mlist.size() > 0)
                {
                    nodeMap.add(mlist);
                }
            } 
		}
		if(nodeMap.size() > 0){
			for (Map<String, String> node : nodeMap)
            {
                Integer msgId = null;
				Class handlerClass = null;
                for (Entry<String, String> entry : node.entrySet())
                {
                    switch (entry.getKey())
                    {
                        case "msgId":
                            msgId = Integer.parseInt(entry.getValue());
                            break;
                        case "class":
                            handlerClass = Class.forName(entry.getValue());
                            if (handlerClass.getSuperclass() != MessageHandler.class)
                            {
                                logger.error("Class type error! 'handler' must be com.space.message.ReceiveMessage.MessageHandler: "
                                        + entry.getValue() + ", file: " + filePath);
                            }
                            break;
                        default:
                            break;
                    }
                }
                
                if (handlerClass == null)
                {
                    logger.error("Not found 'handler'!  file: " + filePath);
                    return;
                }
                
                if (msgId == null)
                {
                	logger.error("Not found 'msgId'!  file: " + filePath);
                    return;
                }
                logger.info("Load message>> " + msgId + ":[handler " + handlerClass + "]");
                handlerMap.put(msgId, new MessageBean(msgId, handlerClass));
            }
		}else
        {
            logger.error("No messages! loading cancelled. file: " + filePath);
        }
	}
    
    
   	public static Map<Integer, MessageBean> getHandlermap() {
   		return handlerMap;
   	}
	
}
