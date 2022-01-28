package com.example.demo_amigocode.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Student {
	@Id
	@SequenceGenerator(
			name = "student_sequence",
			sequenceName = "student_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence"
			)
	
	private Long id;
	@Transient
	private Integer age;
	private String name;
	private LocalDate dob;
	private String email;
	public Student() {
		
	}
	public Student(Long id, String name, LocalDate dob, String email){
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
	}
	public Student(String string, LocalDate of, String string2) {
		// TODO Auto-generated constructor stub

		this.name = string;
		this.email = string2;
		this.dob = of;
	}
	public Long getId() {
		return id;
	}
	public Integer getAge() {
		return Period.between(dob, LocalDate.now()).getYears();
	}
	public String getName() {
		return name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "name " + this.name + " dob " + this.dob + " email " + this.email;
	}
}
