package com.sprint1.tourmanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_info")
public class User {
	@Id
	@GeneratedValue(
			strategy=GenerationType.SEQUENCE,
			generator="userGenerator"		
	)
	
	@SequenceGenerator(
			name="userGenerator",
			sequenceName="userSequence",
			initialValue=1,
			allocationSize=1
			)
	@Column(name="userId")
	private int userId;
	
	@Size(min=3,max=50,message="Name length should be between 3 and 10")
	@Column(name="userName",nullable=false)
	private String userName;
	
	@Column(name="userContact",length=10,nullable=false)
	private long userContact;
	
	@Column(name="userUserId",unique=true,nullable=false)
	@Size(min=5,max=10,message="UserID length should be between 5 and 10")
	private String userUserId;
	
	@Column(name="userPassword",nullable=false)
	private String userPassword;
	
	@Column(name="userType",columnDefinition="VARCHAR(60) CHECK (userType IN ('Admin', 'Staff', 'Customer'))")
	//@Column(name="userType")
	private String userType;
	
	@JoinColumn(name="User_Address")
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getUserContact() {
		return userContact;
	}

	public void setUserContact(long userContact) {
		this.userContact = userContact;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserUserId() {
		return userUserId;
	}

	public void setUserUserId(String userUserId) {
		this.userUserId = userUserId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
