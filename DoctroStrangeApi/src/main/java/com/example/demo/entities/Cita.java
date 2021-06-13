package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="citas")
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	@Column(name = "fecha")
private String date;
	@Column(name = "hora")
private String hour;
	@Column(name = "paciente")
private int patient;
	@Column(name = "estado")
private String condition;
	@Column(name = "observaciones")
private String observations;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getHour() {
	return hour;
}
public void setHour(String hour) {
	this.hour = hour;
}
public int getPatient() {
	return patient;
}
public void setPatient(int patient) {
	this.patient = patient;
}
public String getCondition() {
	return condition;
}
public void setCondition(String condition) {
	this.condition = condition;
}
public String getObservations() {
	return observations;
}
public void setObservations(String observations) {
	this.observations = observations;
}

}
