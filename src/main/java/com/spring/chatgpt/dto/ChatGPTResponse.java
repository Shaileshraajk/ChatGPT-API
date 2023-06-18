package com.spring.chatgpt.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ChatGPTResponse {
	
	@JsonProperty("choices")
	private List<Choice> choices;
	
	
	
	
	public ChatGPTResponse(List<Choice> choices) {
		this.choices = choices;
	}



	public ChatGPTResponse() {
	}



	public List<Choice> getChoices() {
		return choices;
	}



	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}



	public static class Choice {
		
		@JsonProperty("index")
		private int index;
		
		@JsonProperty("finish_reason")
		private String finish_reason;
		
		@JsonProperty("message")
		private Message message;
		
		

		public Choice() {
		}

		public Choice(int index, String finish_reason, Message message) {
			this.index = index;
			this.finish_reason = finish_reason;
			this.message = message;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public Message getMessage() {
			return message;
		}

		public void setMessage(Message message) {
			this.message = message;
		}

		public String getFinish_reason() {
			return finish_reason;
		}

		public void setFinish_reason(String finish_reason) {
			this.finish_reason = finish_reason;
		}
		
		
		
		
		
		
	}

}
