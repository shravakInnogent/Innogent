package com.innogent.demo.controller;

import java.util.List;
import com.innogent.demo.entity.Student;
import com.innogent.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    Student create(@RequestBody Student student){
         return studentService.create(student);
    }

    @GetMapping("/getStudents")
    List<Student>  getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/getStudentById/{id}")
    Student  getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    String update(@RequestBody Student student,
    @PathVariable Integer id){
       return studentService.update(student, id);
    }


    @DeleteMapping("/delete/{id}")
    String delete(@PathVariable Integer id){
        return studentService.delete(id);
    }
}
