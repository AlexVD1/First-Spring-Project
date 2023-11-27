package com.example.models;

import jakarta.persistence.*;
import lombok.Data;

@Data @Entity @Table(name = "users")
public class UserC {

	@Id
	@Column(name = "id") @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "email")
	private String email;

	@Column(name = "phonenumber")
	private String phonenumber;

	@Column(name = "password")
	private String password;


	public UserC(){}
	public UserC(Long id, String name, String lastname, String email, String phonenumber, String password) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.password = password;
	}
}
