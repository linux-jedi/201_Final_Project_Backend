package models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bathroom {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	private String name;
	
	private String description;
	
	private Integer votes;
	
	private String location_description;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Integer getVotes() {
		return votes;
	}

	public String getLocation_description() {
		return location_description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public void setLocation_description(String location_description) {
		this.location_description = location_description;
	}
	
	
}
