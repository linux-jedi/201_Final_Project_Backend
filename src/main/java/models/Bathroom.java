package models;

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
	
	private String address;
	
	private Integer points;
	
	private boolean hasDisabilityAccomodations;
    
	private boolean requiresKey;
    
	private double longitude;
    
	private double latitude;

    private boolean upArrowSelected;
    
    private boolean downArrowSelected;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public boolean isHasDisabilityAccomodations() {
		return hasDisabilityAccomodations;
	}

	public void setHasDisabilityAccomodations(boolean hasDisabilityAccomodations) {
		this.hasDisabilityAccomodations = hasDisabilityAccomodations;
	}

	public boolean isRequiresKey() {
		return requiresKey;
	}

	public void setRequiresKey(boolean requiresKey) {
		this.requiresKey = requiresKey;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public boolean isUpArrowSelected() {
		return upArrowSelected;
	}

	public void setUpArrowSelected(boolean upArrowSelected) {
		this.upArrowSelected = upArrowSelected;
	}

	public boolean isDownArrowSelected() {
		return downArrowSelected;
	}

	public void setDownArrowSelected(boolean downArrowSelected) {
		this.downArrowSelected = downArrowSelected;
	}
}
