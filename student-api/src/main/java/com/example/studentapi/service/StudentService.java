package com.example.studentapi.service;

import com.example.studentapi.entity.Student;
import com.example.studentapi.exception.StudentNotFoundException;
import com.example.studentapi.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Transactional(readOnly = true)
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Student getStudentById(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException(id));
	}

	@Transactional
	public Student addStudent(Student student) {
		student.setId(null);
		return studentRepository.save(student);
	}

	@Transactional
	public Student updateStudent(Long id, Student updated) {
		Student existing = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException(id));
		existing.setName(updated.getName());
		existing.setEmail(updated.getEmail());
		existing.setCourse(updated.getCourse());
		existing.setAge(updated.getAge());
		return studentRepository.save(existing);
	}

	@Transactional
	public void deleteStudent(Long id) {
		Student existing = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException(id));
		studentRepository.delete(existing);
	}
}