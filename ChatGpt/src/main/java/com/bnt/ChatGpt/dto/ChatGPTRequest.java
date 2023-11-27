package com.bnt.ChatGpt.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.ToString;

@ToString
public class ChatGPTRequest {
	private String model;
    private List<Message> messages;
    

    public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public List<Message> getMessages() {
		return messages;
	}


	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}


	public ChatGPTRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user",prompt));
    }

}
