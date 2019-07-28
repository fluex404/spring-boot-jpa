package com.fluex404.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name="todos")
public class Todo {
	static final int MAX_LENGTH_DESCRIPTION = 500;
	static final int MAX_LENGTH_TITLE = 100;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="created_by_user", nullable = false)
	@CreatedBy
	private String creatdeByUser;
	
	@Column(name="creation_time", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
	@CreatedDate
	private ZonedDateTime creationTime;
	
	@Column(name = "description", length = MAX_LENGTH_DESCRIPTION)
	private String description;
	
	@Column(name = "modified_by_user", nullable = false)
	@LastModifiedBy
	private String modifiedByUser;
	
	@Column(name="modification_time")
	@Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime")
	@LastModifiedDate
	private ZonedDateTime modificationTime;
	
	@Column(name="title", nullable = false, length = MAX_LENGTH_TITLE)
	private String title;
	
	@Version
	private long version;
	
	public Todo() {
		// TODO Auto-generated constructor stub
	}
	private Todo(Builder builder) {
		this.title = builder.title;
		this.description = builder.description;
	}
	static Builder getBuilder() {
		return new Builder();
	}
	public Long getId() {
		return id;
	}
	public String getCreatdeByUser() {
		return creatdeByUser;
	}
	public ZonedDateTime getCreationTime() {
		return creationTime;
	}
	public String getDescription() {
		return description;
	}
	public String getModifiedByUser() {
		return modifiedByUser;
	}
	public ZonedDateTime getModificationTime() {
		return modificationTime;
	}
	public String getTitle() {
		return title;
	}
	public long getVersion() {
		return version;
	}
	
	static class Builder{
		private String description;
		private String title;
		
		public Builder() {
			// TODO Auto-generated constructor stub
		}
		
		Builder description(String description) {
			this.description = description;
			return this;
		}
		Builder title(String title) {
			this.title = title;
			return this;
		}
		Todo build() {
			Todo build = new Todo(this);
			return build;
		}
	}
}
