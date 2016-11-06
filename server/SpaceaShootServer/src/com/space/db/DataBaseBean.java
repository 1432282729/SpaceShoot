package com.space.db;

import java.util.Properties;

/**
 * 专门放数据库的配置信息
 * url,username,password
 * @author Administrator
 *
 */

public class DataBaseBean {
	
	private String driver;
	private String url;
    private String username;
    private String password;
    
    public DataBaseBean(String url, String username, String password)
    {
    	this.driver = "com.mysql.jdbc.Driver";
        this.url = url;
        this.username = username;
        this.password = password;
    }
    
    public Properties getProperties()
    {
        Properties properties = new Properties();
        properties.put("driver", driver);
        properties.put("url", url);
        properties.put("username", username);
        properties.put("password", password);
        return properties;
    }
    
    public String getDriver() {
		return driver;
	}

	public String getUrl()
    {
        return url;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }
	
    
}
