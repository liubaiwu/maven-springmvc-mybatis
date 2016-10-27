package cn.springmvc.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.springmvc.core.JsonHelper;
import redis.clients.jedis.JedisCluster;

@Service
public class RedisClusterCache implements ICacheManager {

	
	JedisCluster jc;
	public RedisClusterCache() {
		// TODO Auto-generated constructor stub
		jc=RedisClusterHelper.Instance();
	}
	
	
	/**
	 * 获取缓存值
	 */
	@Override
	public <T> T Get(String key) {
		T t= (T) jc.get(key);
		return t;
	}

	/**
	 * 设置缓存
	 */
	@Override
	public <T> void Set(String key,T t) {
		
		String value=JsonHelper.Create().toJson(t);
		
		jc.set(key,value);
	}

}
