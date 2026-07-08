package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Student;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) {

        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void updateStudent(Student student) {

        Student existing = getStudentById(student.getId());

        if (existing != null) {
            existing.setName(student.getName());
            existing.setCourse(student.getCourse());
            existing.setEmail(student.getEmail());
            existing.setMobile(student.getMobile());
        }
    }

    public void deleteStudent(int id) {

        students.removeIf(student -> student.getId() == id);
    }
}