package com.first.taskmanager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@GetMapping("/hello")
	String hello(){
		return "Hello, welcome to Aakriti's World";
	}
}
