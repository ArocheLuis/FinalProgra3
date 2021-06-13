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

import com.example.demo.entities.Paciente;
import com.example.demo.repositories.PatientsRepository;

@RestController
@RequestMapping(value ="/pacientes")
public class PatientsControllers {
	@Autowired
	PatientsRepository repository;
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	//Lista de pacientes
	public Collection<Paciente> getListaPacientes(){
		Iterable<Paciente> listaPacientes = repository.findAll();
		return (Collection<Paciente>) listaPacientes;	
	}
	//buscar por un id, pacientes en especifico)
		@GetMapping(value = "/{id}")
		@ResponseStatus(code = HttpStatus.OK)
		public Paciente getPaciente(@PathVariable(name ="id")Long id) {
		Optional<Paciente> paciente = repository.findById(id);
		 Paciente result = null;
		if (paciente.isPresent()) {
			result=paciente.get();
		}
		return result;
		}
		
		 // editar paciente
		 @PutMapping(value = "/{id}")
		 @ResponseStatus(code = HttpStatus.ACCEPTED)
		 public Paciente updatePaciente(@PathVariable (name = "id")Long id, 
				 @RequestBody Paciente paciente) {
			Optional<Paciente> oPaciente = repository.findById(id) ;
			if (oPaciente.isPresent()) {
				Paciente actl = oPaciente.get();
				actl.setId(id);
				actl.setName(paciente.getName());
				actl.setSecond_name(paciente.getSecond_name());  
				actl.setSurname(paciente.getSurname());
				actl.setSecond_surname(paciente.getSecond_surname());
				actl.setAge(paciente.getAge());
				Paciente updatedPaciente = repository.save(actl);
				return updatedPaciente;
			}
			return null;
		 }
		//borrar paciente
		 @DeleteMapping(value = "{id}")
		 @ResponseStatus(code = HttpStatus.ACCEPTED)
		 public void deletePaciente(@PathVariable(name = "id") Long id ) {
			repository.deleteById(id); 
		 }
		 //crear un nuevo paciente
		 @PostMapping
			@ResponseStatus(code = HttpStatus.CREATED)
			public Paciente createPaciente(@RequestBody Paciente paciente) {
				Paciente nuevoPaciente =repository.save(paciente);
				return nuevoPaciente;	
			}
}
