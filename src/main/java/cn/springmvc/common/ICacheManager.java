package cn.springmvc.common;

public interface ICacheManager {
	/**
	 * 获取缓存
	 * @param key
	 * @return
	 */
	public <T> T Get(String key);
	
	/**
	 * 设置缓存
	 * @param t
	 */
	public <T> void Set(String key,T t);
}
