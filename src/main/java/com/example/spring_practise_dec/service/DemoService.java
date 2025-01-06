package com.example.spring_practise_dec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_practise_dec.Model.DemoDTO;
import com.example.spring_practise_dec.controller.repo.DemoRepo;

@Service
public class DemoService {

    @Autowired
    DemoRepo dr;

    public void saveData(DemoDTO d) {
        dr.save(d);
    }

    public List<DemoDTO> getData() {
        return dr.findAll();
    }

    public DemoDTO getById(Integer id) {
        // Return the DemoDTO by id. If not found, return null
        return dr.findById(id).orElse(null);  // Return null if not found
    }

    public boolean updateDetails(Integer id, DemoDTO d) {
        // Check if the record with the provided ID exists
        Optional<DemoDTO> existingRecord = dr.findById(id);

        if (existingRecord.isPresent()) {
            DemoDTO recordToUpdate = existingRecord.get();

            // Update the fields with the values from the request body (DemoDTO d)
            recordToUpdate.setName(d.getName());
            recordToUpdate.setAge(d.getAge());

            // Save the updated record back to the database
            dr.save(recordToUpdate);
            return true;  // Successfully updated
        } else {
            return false;  // Record with the given ID not found
        }
    }
}
