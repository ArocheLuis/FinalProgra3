package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Cita;

public interface QuotesRepository extends CrudRepository <Cita, Long>{

}
