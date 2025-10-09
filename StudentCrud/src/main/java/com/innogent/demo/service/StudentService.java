package com.innogent.demo.service;

import com.innogent.demo.entity.Student;
import com.innogent.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student create( Student student){
        return studentRepository.save(student);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id){
        Optional<Student> s =  studentRepository.findById(id);
            return s.get();
    }

    public String update(Student student, Integer id){
        Student s  = getStudentById(id);
        s.setId(id);
        s.setName(student.getName());
        s.setEmail(student.getEmail());
        studentRepository.save(s);
        return "SUCCESS";
    }

    public String delete(Integer id){
        Student student1 =  getStudentById(id);
        studentRepository.delete(student1);
        return "Successfully Deleted.";
    }
}
