package com.live.myinstaclone.Model;

public class Story {
	private String imageUrl;
	private String name;
	private boolean outline;
	
	public Story(String imageUrl,String name, boolean outline) {
		this.imageUrl = imageUrl;
		this.name=name;
		this.outline = outline;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isOutline() {
		return outline;
	}
	
	public void setOutline(boolean outline) {
		this.outline = outline;
	}
}
