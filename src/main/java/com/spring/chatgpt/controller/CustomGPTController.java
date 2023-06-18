package com.spring.chatgpt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.chatgpt.dto.ChatGPTRequest;
import com.spring.chatgpt.dto.ChatGPTResponse;

@RestController
@RequestMapping("/cgpt")
public class CustomGPTController {

	@Value("${openai.model}")
	private String model;

	@Value(("${openai.api.url}"))
	private String apiURL;

	@Autowired
	private RestTemplate template;

	@GetMapping("/chatAPI")
	public String chat(@RequestParam("prompt") String prompt) {

		ChatGPTRequest request = new ChatGPTRequest(model, prompt);
		ChatGPTResponse chatGptResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);
		return chatGptResponse.getChoices().get(0).getMessage().getContent();

	}
	
	@PostMapping("/chatAPI")
	public String chatAPI(@RequestBody ChatGPTRequest request) {

//		request = new ChatGPTRequest(model, prompt);
		ChatGPTResponse chatGptResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);
		return chatGptResponse.getChoices().get(0).getMessage().getContent();

	}
	

}
