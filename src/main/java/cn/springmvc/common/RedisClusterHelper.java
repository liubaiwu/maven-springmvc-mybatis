package cn.springmvc.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Service;

import cn.springmvc.core.Convert;
import cn.springmvc.core.CusUtils;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
/**
 * redis 群集 操作对象创建
 * @author Administrator
 *
 */
@Service
public class RedisClusterHelper {

	private static Lock lock = new ReentrantLock();// 锁对象 
	
	public static JedisCluster jc;
	
	static List<String> hostAndPort;
	
	public List<String> getHostAndPort() {
		return hostAndPort;
	}

	public void setHostAndPort(List<String> hostAndPort) {
		this.hostAndPort = hostAndPort;
	}

	/**
	 * 获取Redis群集连接对象
	 * @return
	 */
	public static JedisCluster Instance()
	{
		if(jc==null)
		{
			lock.lock();// 得到锁  
			try
			{
				if(jc==null)
				{
					Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();  
				    if(hostAndPort!=null)
				    {
				    	for(String item : hostAndPort){
				    		if(!CusUtils.StringIsNullOrEmpty(item))
				    		{
				    			String[] keyValue=item.split(":");
				    			String host=keyValue[0];
				    			int port=Convert.ToInt(keyValue[1], 0);
				    			jedisClusterNodes.add(new HostAndPort(host, port));
				    		}
				    		else
				    		{
				    			//throw new Exception("请检查redis的配置");
				    		}
				    	}
				    }
				    /*
				    jedisClusterNodes.add(new HostAndPort("192.168.2.201", 7000));  
				    jedisClusterNodes.add(new HostAndPort("192.168.2.201", 7001));  
				    jedisClusterNodes.add(new HostAndPort("192.168.2.201", 7002));  
				    jedisClusterNodes.add(new HostAndPort("192.168.2.201", 7003));  
				    jedisClusterNodes.add(new HostAndPort("192.168.2.201", 7004));  
				    jedisClusterNodes.add(new HostAndPort("192.168.2.201", 7005)); 
				    */         
				    jc = new JedisCluster(jedisClusterNodes);
				}
			}
			finally{
				lock.unlock();// 释放锁  
			}
			
		}
	    return jc;
	}
	
}
