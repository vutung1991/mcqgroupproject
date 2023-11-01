package com.example.mcqgroupbe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserContactDetails {
	@Id
	private long userId;
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	
	@OneToOne
    @JoinColumn(name = "userId")
    @MapsId
    private User user;
	
	public void setEmail(String email){
		this.email=email;
	}
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	public void setUser(User user) {
		this.user=user;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public User getUser() {
		return user;
	}
	
	
	
}
