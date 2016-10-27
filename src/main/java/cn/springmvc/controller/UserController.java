package cn.springmvc.controller;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.springmvc.common.ICacheManager;
import cn.springmvc.common.RedisClusterCache;
import cn.springmvc.model.User;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

	//demo测试
	@Controller
	@RequestMapping("/")
	public class UserController {

		@Autowired()
		RedisClusterCache redisClusterCache;
		
		
		@RequestMapping("index.do")
		public String index(){
			
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
			redisClusterCache.Set(s, u);
			System.out.print(s);
			return "index";
		}
		
	}

