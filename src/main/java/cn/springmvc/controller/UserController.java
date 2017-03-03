package cn.springmvc.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.common.ICacheManager;
import cn.springmvc.common.RedisClusterCache;
import cn.springmvc.model.User;
import cn.springmvc.service.UserService;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

	//demo测试
	@Controller
	@RequestMapping("/")
	public class UserController {

		@Autowired()
		RedisClusterCache redisClusterCache;
		
		@Autowired()
		UserService user;
		
		@RequestMapping("index.do")
		public String index(Model m){
			
			
			
			
			
         
			
			
			
			
			
			
			
			/*
			Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();  
	        
	        jedisClusterNodes.add(new HostAndPort("192.168.2.201", 7000));  
	        jedisClusterNodes.add(new HostAndPort("192.168.2.201", 7001));  
	        jedisClusterNodes.add(new HostAndPort("192.168.2.201", 7002));  
	        jedisClusterNodes.add(new HostAndPort("192.168.2.201", 7003));  
	        jedisClusterNodes.add(new HostAndPort("192.168.2.201", 7004));  
	        jedisClusterNodes.add(new HostAndPort("192.168.2.201", 7005));          
	        JedisCluster jc = new JedisCluster(jedisClusterNodes); 
	        jc.set("test1", "test11122----");
	        */
//			ICacheManager redis=new RedisClusterCache();
		
			User u=new User();
			String s="222"+ new Random().nextDouble();
			u.setNickname(s);
			u.setState(1);
			
			user.insertUser(u);
			
			redisClusterCache.Set(s, u);
			
			System.out.print(s);
			
			
			
			
			 
			
			 
			   
			 
			   
			   Date a = new Date();
			Jedis jedis=new Jedis("192.168.2.200", 6379);
			int i=0;
			while(true)
			{
				Date b = new Date();
				long interval = (b.getTime() - a.getTime())/1000;
				if(interval > 1)
				{
					break;
				}
				jedis.set("java"+i, "--"+i);
				i++;
			}
			
			System.out.print("------+++++++++=-------"+i);
			
			
			m.addAttribute("result", i+"条");
			
			
			return "index";
		}
		
		@RequestMapping(value="SetRedis.do",method=RequestMethod.GET)
		@ResponseBody
		public void SetRedis(String key,String value,Model m)
		{
			Jedis jedis=new Jedis("192.168.2.200", 6379);
			jedis.set(key, value);
		}
		@RequestMapping(value="test.do",method=RequestMethod.GET)
		public void Test()
		{
			//自动根据哨兵切换获取当前可用服务器
			 JedisPoolConfig poolConfig = new JedisPoolConfig();
	         String masterName = "mymaster";
	         Set<String> sentinels = new HashSet<String>();
	         sentinels.add("192.168.2.46:26379");
	         sentinels.add("192.168.2.46:26380");
	         JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(masterName, sentinels, poolConfig);
	         HostAndPort currentHostMaster = jedisSentinelPool.getCurrentHostMaster();
	         System.out.println(currentHostMaster.getHost()+"--"+currentHostMaster.getPort());//获取主节点的信息
	         Jedis resource = jedisSentinelPool.getResource();
	        String value = resource.get("a");
	         System.out.println(value);//获得键a对应的value值
	         resource.close();
		}
		
	}

