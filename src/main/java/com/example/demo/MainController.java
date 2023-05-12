package com.example.demo;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 
@Controller
public class MainController {
 
	@GetMapping(path = "/")
	String login() {
		return "main";
	}
	
}