package cn.springmvc.core;

/**
 * 类型转换帮助类
 * @author Administrator
 *
 */
public class Convert {
	/**
	 * 字符转int
	 * @param value
	 * @param defval
	 * @return
	 */
	public static Integer ToInt(String value,Integer defval)
	{
		try
		{
			if(!CusUtils.StringIsNullOrEmpty(value))
			{
				return Integer.parseInt(value);
			}
			return defval;
		}catch(Exception ex){
			return defval;
		}
		
	}
}
