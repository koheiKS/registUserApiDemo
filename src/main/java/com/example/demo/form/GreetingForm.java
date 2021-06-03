package com.example.demo.form;

public class GreetingForm {

	private final long id;
	private final String content;

	public GreetingForm(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
