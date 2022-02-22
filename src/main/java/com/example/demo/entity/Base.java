package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class Base {
	
	private String crUser;
	
	private LocalDateTime crDateTime;
	
    private String upUser;

    private LocalDateTime upDateTime;
	
}
