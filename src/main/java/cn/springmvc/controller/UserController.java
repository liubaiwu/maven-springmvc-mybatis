package cn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

	//demo测试
	@Controller
	@RequestMapping("/")
	public class UserController {

		@RequestMapping("index.do")
		public String index(){
			return "index";
		}
		
	}

