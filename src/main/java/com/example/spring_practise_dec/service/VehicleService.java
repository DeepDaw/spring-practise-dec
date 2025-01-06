package com.example.spring_practise_dec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_practise_dec.Model.VehicleList;
import com.example.spring_practise_dec.controller.repo.VehicleRepo;
@Service
public class VehicleService {

	@Autowired
	VehicleRepo vr;
	
	public void addVehicle(VehicleList vl) {
		vr.save(vl);
		
	}

	public List<VehicleList> getVehicle() {
		// TODO Auto-generated method stub
		return vr.findAll();
	}

	public VehicleList getVehiById(Integer id) {
		// TODO Auto-generated method stub
		return vr.findById(id).get();
	}

	public void updateById(VehicleList vl, Integer id) {
	    Optional<VehicleList> optionalVehicle = vr.findById(id);
	    
	    if (optionalVehicle.isPresent()) {
	        VehicleList toUpdate = optionalVehicle.get();
	        
	        // Update fields as needed
	        toUpdate.setName(vl.getName()); // Example
	        toUpdate.setNo(vl.getNo()); // Example
	        
	        // Save the updated object back to the database
	        vr.save(toUpdate);
	    } else {
	        throw new RuntimeException("Vehicle with ID " + id + " not found.");
	    }
	}

}
