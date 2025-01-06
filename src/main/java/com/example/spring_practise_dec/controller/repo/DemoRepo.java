package com.example.spring_practise_dec.controller.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_practise_dec.Model.DemoDTO;
@Repository
public interface DemoRepo extends JpaRepository<DemoDTO,Integer> {

}
