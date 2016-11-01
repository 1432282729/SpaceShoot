package com.space.message;

import com.space.message.ReceiveMessage;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * <b>处理客户端消息的抽象基类.</b>
 * <p>
 * Description...
 * <p>
 * <b>Sample:</b>
 * @version 1.0.0
 */
public abstract class MessageHandler
{
    private ReceiveMessage message; // 待处理的消息

    
    public abstract void action();
    
    /**
     * 获取待处理的消息.
     *
     * @return
     */
    public ReceiveMessage getMessage()
    {
        return message;
    }

    /**
     * 设置待处理的消息.
     *
     * @param message
     */
    public void setMessage(ReceiveMessage message)
    {
        this.message = message;
    }

}
