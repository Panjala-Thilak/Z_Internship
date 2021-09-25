package com.zemoso.springdemo.controller;

import com.zemoso.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void loadData(){
        students=new ArrayList<>();
        students.add(new Student("thilak","panjala"));
        students.add(new Student("thanuja","panjala"));
        students.add(new Student("nani","bandi"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
    return students;
    }


    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if((studentId>= students.size())||(studentId<0)){
            throw new StudentNotFoundException("Student id not Found - "+studentId);
        }
        return students.get(studentId);
    }

}
