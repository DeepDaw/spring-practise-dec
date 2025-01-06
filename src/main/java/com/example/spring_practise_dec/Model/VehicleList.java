package com.example.spring_practise_dec.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class VehicleList {

	private String name;
	
	@Id
	private Integer no;
	
}
