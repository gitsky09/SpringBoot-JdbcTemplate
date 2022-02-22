package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserEntity extends Base{
	
	private int id;

	private String name;
	
	private String account;
	
	private String password;
}
