package com.example.demo.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Cita;
import com.example.demo.repositories.QuotesRepository;


@RestController
@RequestMapping(value ="/citas")
public class QuotesControllers {
	@Autowired
	
QuotesRepository repository;
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	//Lista de citas
	public Collection<Cita>getListaCitas(){
		Iterable<Cita> listaCitas = repository.findAll();
		return (Collection<Cita>) listaCitas;
	}
	//buscar por un id las citas
			@GetMapping(value = "/{id}")
			@ResponseStatus(code = HttpStatus.OK)
			public Cita getCita(@PathVariable(name ="id")Long id) {
			Optional<Cita> cita = repository.findById(id);
			 Cita result = null;
			if (cita.isPresent()) {
				result=cita.get();
			}
			return result;
			}
			 // editar cita
			 @PutMapping(value = "/{id}")
			 @ResponseStatus(code = HttpStatus.ACCEPTED)
			 public Cita updateCita(@PathVariable (name = "id")Long id, 
					 @RequestBody Cita cita) {
				Optional<Cita> oCita = repository.findById(id) ;
				if (oCita.isPresent()) {
					Cita actl = oCita.get();
					actl.setDate(cita.getDate());
					actl.setHour(cita.getHour());
					actl.setPatient(cita.getPatient());
					actl.setCondition(cita.getCondition());
					actl.setObservations(cita.getObservations());
					Cita updatedCita = repository.save(actl);
					return updatedCita;
				}
				return null;
			 }
				//borrar cita
			 @DeleteMapping(value = "{id}")
			 @ResponseStatus(code = HttpStatus.ACCEPTED)
			 public void deleteCita(@PathVariable(name = "id") Long id ) {
				repository.deleteById(id); 
			 }
			 //crear una nueva cita
			 @PostMapping
				@ResponseStatus(code = HttpStatus.CREATED)
				public Cita createCita(@RequestBody Cita cita) {
					Cita nuevaCita =repository.save(cita);
					return nuevaCita;	
				}
}
