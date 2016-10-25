package cn.springmvc.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

	//demo测试
	@Controller
	@RequestMapping("/")
	public class UserController {

		@RequestMapping("index.do")
		public String index(){
			
			
			Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();  
	        
	        jedisClusterNodes.add(new HostAndPort("192.168.2.201", 7000));  
	        jedisClusterNodes.add(new HostAndPort("192.168.2.201", 7001));  
	        jedisClusterNodes.add(new HostAndPort("192.168.2.201", 7002));  
	        jedisClusterNodes.add(new HostAndPort("192.168.2.201", 7003));  
	        jedisClusterNodes.add(new HostAndPort("192.168.2.201", 7004));  
	        jedisClusterNodes.add(new HostAndPort("192.168.2.201", 7005));          
	        JedisCluster jc = new JedisCluster(jedisClusterNodes); 
	        jc.set("test1", "test11122----");
			return "index";
		}
		
	}

