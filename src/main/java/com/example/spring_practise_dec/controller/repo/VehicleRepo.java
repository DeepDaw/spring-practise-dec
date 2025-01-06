package com.example.spring_practise_dec.controller.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_practise_dec.Model.VehicleList;

public interface VehicleRepo extends JpaRepository<VehicleList, Integer>{

}
