package com.example.spring_practise_dec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_practise_dec.Model.VehicleList;
import com.example.spring_practise_dec.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	VehicleService vs;
	
	@PostMapping("add")
	public ResponseEntity<String> addVehicle(@RequestBody VehicleList vl){
		vs.addVehicle(vl);
		System.out.print("deep/test");		
		return new ResponseEntity<>("added",HttpStatus.OK);
		
	}
	@GetMapping("getvehi")
		public ResponseEntity<List<VehicleList>> getVehicle(){
			List<VehicleList> l1=vs.getVehicle();
			
			return new ResponseEntity<>(l1,HttpStatus.OK);
		}
	
	@GetMapping("/get/{id}")
		public ResponseEntity<VehicleList> getVehiById(@PathVariable Integer id){
		VehicleList v=vs.getVehiById(id);
		
		return new ResponseEntity<>(v,HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateById(@RequestBody VehicleList vl,@PathVariable Integer id){
		
		vs.updateById(vl,id);
		return new ResponseEntity<>("updated",HttpStatus.ACCEPTED);
	}
	}
	

