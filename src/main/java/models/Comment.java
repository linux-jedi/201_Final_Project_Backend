package models;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	private String title;
	
	private String commentText;
	
	private LocalTime dateCreated;
	
	private Integer userId;
	
	private Integer bathroomId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public LocalTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBathroomId() {
		return bathroomId;
	}

	public void setBathroomId(Integer bathroomId) {
		this.bathroomId = bathroomId;
	}
}
