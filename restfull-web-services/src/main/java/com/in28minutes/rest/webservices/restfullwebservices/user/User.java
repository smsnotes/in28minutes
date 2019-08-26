package com.in28minutes.rest.webservices.restfullwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@ApiModel(description = "User model")
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@ApiModelProperty(notes = "length grader then 2")
	@Size(min = 2,message = "Name have to be longer then 2 chars")
	private String name;

	@ApiModelProperty(notes = "only in the past value")
	@Past(message = "birth date should be in the feature")
	private Date birthDate;

	@OneToMany(mappedBy = "user")
	private List<Post> posts;

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public User() {
	}

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

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
}
