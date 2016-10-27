package cn.springmvc.core;

import com.google.gson.Gson;

/**
 * json帮助类
 * @author Administrator
 *
 */
public class JsonHelper {


	/**
	 * 创建Gosn对象
	 * @return
	 */
	public static Gson Create()
	{
		Gson gson = new Gson();  
		return gson;
	}
}
