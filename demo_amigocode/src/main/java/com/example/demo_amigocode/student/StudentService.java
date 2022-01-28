package com.example.demo_amigocode.student;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class StudentService {
	private final StudentRepository studentRepository;
	@Autowired
	public StudentService(StudentRepository studentRepository){
		this.studentRepository = studentRepository;
	}
	public List<Student> getStudent() {
		return studentRepository.findAll();
	}
	public void addNewStudent(Student student) {
		// TODO Auto-generated method stub
		Optional<Student> optionalStudent = studentRepository.findStudentByEmail(student.getEmail());
		if(optionalStudent.isPresent()) {
			throw new IllegalStateException("Email is taken ");
		}
		studentRepository.save(student);
		System.out.println(student);
	}
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		boolean exists = studentRepository.existsById(id);
		if(!exists) {
			throw new IllegalStateException("Email doesn't exists");
		}
		studentRepository.deleteById(id);
		
	}
	@Transactional
	public void updateStudent(Long id, String name, String email) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("person doesn't exist"));
		
		if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		if(email != null && email.length() > 0 && !Objects.equals(email, student.getEmail())) {
			Optional<Student> optionalStudent = studentRepository.findStudentByEmail(email);
			if(optionalStudent.isPresent()) {
				throw new IllegalStateException("Email already exists");
			}
			student.setEmail(email);
		}
	}
}
