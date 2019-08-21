package com.in28minutes.rest.webservices.restfullwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "User model")
public class User {


	public User() {
	}

	private Integer id;

	@ApiModelProperty(notes = "length grader then 2")
	@Size(min = 2,message = "Name have to be longer then 2 chars")

	private String name;

	@ApiModelProperty(notes = "only in the past value")
	@Past(message = "birth date should be in the feature")
	private Date birthDate;

	public String getSecureVaultID() {
		return secureVaultID;
	}

	public void setSecureVaultID(String secureVaultID) {
		this.secureVaultID = secureVaultID;
	}

	@JsonIgnore
	private String secureVaultID;

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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
     
}
