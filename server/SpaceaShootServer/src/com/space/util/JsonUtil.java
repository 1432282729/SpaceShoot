package com.space.util;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
	
	
	/**
	 * 将对象转换成jsonString
	 * @param object
	 * @return
	 */
	public static String parseObjectToJsonString(Object object){
		
		String jsonString = JSON.toJSONString(object); 
		return jsonString;
	}
	
	/**
	 * 将json字符串转化成对象
	 * @param <T>
	 * @param jsonString
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Object parseJsonStringToObject(String jsonString, Class<T> clazz) {
		
		T t = JSON.parseObject(jsonString, clazz); 
		return t;
	} 
	
	/**
	 * 将json字符串转化成map
	 * @param jsonString
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> parseJsonStringToMap(String jsonString) {
		
		Map<String,Object> map = JSON.parseObject(jsonString, Map.class);
		return map;
	} 
	
	/**
	 * 将对象转成json对象
	 * @param obj
	 * @return
	 */
	public static JSONObject parseObjectToJsonObject(Object obj){
		JSONObject jsonObj = null;
		try {
			String json = (String) JSON.toJSONString(obj);
			jsonObj = JSONObject.parseObject(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObj;
	}
	
	/**
	 * 将str转成json对象
	 * @param str
	 * @return
	 */
	public static JSONObject parseStringToJsonObject(String str){
		JSONObject jsonObj = null;
		try {
			jsonObj = JSONObject.parseObject(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObj;
	}
	
}

