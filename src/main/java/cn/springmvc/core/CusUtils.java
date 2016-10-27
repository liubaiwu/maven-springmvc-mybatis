package cn.springmvc.core;

public class CusUtils {
	/**
	 * 验证一个字符是否为Null或空
	 * @param str
	 * @return
	 */
	public static Boolean StringIsNullOrEmpty(String str)
	{
		if(str==null || str.isEmpty())
			return true;
		else
			return false;
	}
}
