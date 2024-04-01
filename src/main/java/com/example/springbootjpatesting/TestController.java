package com.example.springbootjpatesting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/hello")
	public String hello() {
        String response = "sheeeeesh";
        return response;
	}
}
