package com.mrodriguezul.apibeer.bean;

import java.io.Serializable;

public class Beer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String firstBrewed;
	private String description;
	private String imageUrl;
	
	public Beer() {
		super();
	}
	
	public Beer(Long id, String name, String firstBrewed, String description, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.firstBrewed = firstBrewed;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstBrewed() {
		return firstBrewed;
	}

	public void setFirstBrewed(String firstBrewed) {
		this.firstBrewed = firstBrewed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Beer [id=" + id + ", name=" + name + ", firstBrewed=" + firstBrewed + ", description=" + description
				+ ", imageUrl=" + imageUrl + "]";
	}
	
}
