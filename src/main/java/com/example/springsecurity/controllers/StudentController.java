package com.example.springsecurity.controllers;

import com.example.springsecurity.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    public static final List<Student> STUDENT_LIST= Arrays.asList(
      new Student(1,"muli kelvin"),
      new Student(2,"jaosh David"),
      new Student(3,"joe doe")
    );
    @GetMapping("{id}")
    public Student getStudent(@PathVariable Integer id){
        return  STUDENT_LIST.stream()
                .filter(student -> id.equals(student.getId()))
                .findFirst()
                .orElseThrow(()-> new IllegalStateException("student with id"+id+"does not exist"));
    }
}
