package com.bnt.ChatGpt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bnt.ChatGpt.dto.ChatGPTRequest;
import com.bnt.ChatGpt.dto.ChatGptResponse;

@RestController
@RequestMapping("/bot")
public class ChatGptController {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ChatGptController.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${openai.model}")
	private String model;

	@Value("${openai.api.url}")
	private String apiUrl;

	@GetMapping("/chat")
	public ChatGptResponse chat(@RequestParam String prompt) {

		ChatGPTRequest request = new ChatGPTRequest(model, prompt);

		ChatGptResponse response = restTemplate.postForObject(apiUrl, request, ChatGptResponse.class);
		log.info("chatGPT response :{}", response);

		if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
			return null;

		}
		// return response.getChoices().get(0).getMessage().getContent();
		return response;

	}

}
