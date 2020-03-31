package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.Service.UserService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class userController {

	@Autowired
	UserService userService;

	@GetMapping("/dd")
	public String index(Map<String, Object> model) {
		model.put("ID", userService.getUserId());
		return "index";
	}
}
