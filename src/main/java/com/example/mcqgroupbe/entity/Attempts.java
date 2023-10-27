package com.example.mcqgroupbe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Attempts {

	 @Id 
	 @GeneratedValue(strategy = GenerationType.IDENTITY) 
	 private int id;
	 private String username; 
	 private int attempts;
}
