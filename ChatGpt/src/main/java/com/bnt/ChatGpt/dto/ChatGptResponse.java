package com.bnt.ChatGpt.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ChatGptResponse {

	private List<Choice> choices;

	@ToString
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Choice {

		private int index;
		private Message message;
		
		

	}
}
