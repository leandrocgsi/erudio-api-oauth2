package br.com.erudio.vo;

public class GreetingVO {

	private final long id;

	private final String content;

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public GreetingVO(long id, String content) {
		this.id = id;
		this.content = content;
	}

}
