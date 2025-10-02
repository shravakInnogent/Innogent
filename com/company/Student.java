package com.company;

import java.io.Serializable;

public class Student implements Serializable {
    int id;
    String name;
    int  classId;
    int marks;
    String gender;
    int age;

    public String toString(){
        return "ID | Name | Marks | Gender | Age | ClassId \n" + id + "   " + name + "    " + marks + "      " + gender + "   " + age + "      " + classId ;
    }
    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
   public void setGender(String gender){
        this.gender= gender;
   }

    public void setMarks(int marks) throws InvalidMarksException {
        if(marks <0 || marks >100){
            throw new InvalidMarksException("Marks can not be more than 100");
        }
        else{
            this.marks = marks;
        }
    }

    public void setAge(int age)   throws InvalidAgeException {
        if(age > 18){
            throw new InvalidAgeException("Age must be at least 18");
        }
        else {
            this.age = age;
        }
    }
   // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
    public  int getClassId(){ return classId;}
    public int getMarks() {
        return marks;
    }
    
}