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
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_practise_dec.Model.DemoDTO;
import com.example.spring_practise_dec.service.DemoService;

@RestController
public class DemoController {
	@Autowired
	DemoService ds;
	
	
	
@PostMapping("/demo")	
public ResponseEntity<DemoDTO> saveData(@RequestBody DemoDTO d ){
	ds.saveData(d);
	return new ResponseEntity<>(d,HttpStatus.OK);

}
@GetMapping("/getall")
public ResponseEntity<List<DemoDTO>> getData(){
	List<DemoDTO> dt=ds.getData();
	return new ResponseEntity<>(dt,HttpStatus.OK);
}
@GetMapping("/get/{id}")
public ResponseEntity<DemoDTO> getById(@PathVariable Integer id){
	DemoDTO dt=ds.getById(id);
	return new ResponseEntity<>(dt,HttpStatus.OK);
}

@PutMapping("/update/{id}")
public ResponseEntity<String> updateDetails(@PathVariable Integer id, @RequestBody DemoDTO d) {
    boolean isUpdated = ds.updateDetails(id, d);
    if (isUpdated) {
        return new ResponseEntity<>("Details updated successfully!", HttpStatus.OK);
    } else {
        return new ResponseEntity<>("Record not found for the provided ID.", HttpStatus.NOT_FOUND);
    }
}

}
