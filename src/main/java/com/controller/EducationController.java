package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.Student;
import com.service.StudentService;

@RestController
public class EducationController {

    @Autowired
    private StudentService service;
    
    @GetMapping("/hi")
    public String m1() {
    	return "welcome to 21";
    }

    // Add Student
    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student) {

        service.addStudent(student);

        return new ResponseEntity<>("Student Added Successfully", HttpStatus.CREATED);
    }

    // Get All Students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {

        return ResponseEntity.ok(service.getAllStudents());
    }

    // Get Student By ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {

        Student student = service.getStudentById(id);

        if (student != null) {
            return ResponseEntity.ok(student);
        }

        return ResponseEntity.notFound().build();
    }

    // Update Student
    @PutMapping
    public ResponseEntity<String> updateStudent(@RequestBody Student student) {

        service.updateStudent(student);

        return ResponseEntity.ok("Student Updated Successfully");
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {

        service.deleteStudent(id);

        return ResponseEntity.ok("Student Deleted Successfully");
    }
}