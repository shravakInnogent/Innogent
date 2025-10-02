package com.company;
import java.util.*;
import java.util.stream.Collectors;

public class StudentManagement {
    public static void main(String[] args) {

        int id = 0;
        List<Student> stuObj = new ArrayList<>(); //holds objects of Student
        Student obj1 = new Student();
        //Hardcoded Students

        //obj 1
        obj1.setName("Shravak");
        try {
            obj1.setAge(15);
        }
        catch (InvalidAgeException e){
            System.out.println("Exception Caught: " + e.getMessage() );
        }

        try {
            obj1.setMarks(78);
        }catch (InvalidMarksException e){
            System.out.println("Exception caught:" + e.getMessage());
        }
        obj1.setGender("Male");
        obj1.setId(++id);
        obj1.setClassId(2);
        stuObj.add(obj1);

        //obj 2
        Student obj2 = new Student();
        obj2.setName("Chanchal");
        try {
            obj2.setAge(18);
        } catch (InvalidAgeException e){
            System.out.println("Exception Caught: " + e.getMessage() );
        }
        try {
            obj2.setMarks(88);
        }catch (InvalidMarksException e){
            System.out.println("Exception caught:" + e.getMessage());
        }
        obj2.setGender("Female");
        obj2.setId(++id);
        obj2.setClassId(2);
        stuObj.add(obj2);

        //Obj 3
        Student obj3 = new Student();
        obj3.setName("Sakshi");
        try {
            obj3.setAge(12);
        } catch (InvalidAgeException e){
            System.out.println("Exception Caught: " + e.getMessage() );
        }
        try {
            obj3.setMarks(15);
        }catch (InvalidMarksException e){
            System.out.println("Exception caught: " + e.getMessage());
        }
        obj3.setGender("Female");
        obj3.setId(++id);
        obj3.setClassId(1);
        stuObj.add(obj3);

        //obj 4
        Student obj4 = new Student();
        obj4.setName("Sejal");
        try {
            obj4.setAge(11);
        }
        catch (InvalidAgeException e){
            System.out.println("Exception Caught: " + e.getMessage() );
        }
        try {
            obj4.setMarks(95);
        }catch (InvalidMarksException e){
            System.out.println("Exception caught: " + e.getMessage());
        }
        obj4.setGender("Female");
        obj4.setId(++id);
        obj4.setClassId(3);
        stuObj.add(obj4);

        //obj 5
        Student obj5 = new Student();
        obj5.setName("Akshay");
        try {
            obj5.setAge(17);
        }
        catch (InvalidAgeException e){
            System.out.println("Exception Caught: " + e.getMessage() );
        }
        try {
            obj5.setMarks(90);
        }catch (InvalidMarksException e){
            System.out.println("Exception caught: " + e.getMessage());
        }
        obj5.setGender("Male");
        obj5.setId(++id);
        obj5.setClassId(2);
        stuObj.add(obj5);

        List<Address> addressObj = new ArrayList<>(); // Holds Address Objects
        id = 10;

        Address add1 = new Address();
        add1.setCity("Pune");
        add1.setPinCode(411001);
        add1.setID(++id);
        add1.setStudentId(1);
        addressObj.add(add1);

        Address add2 = new Address();
        add2.setCity("Indore");
        add2.setPinCode(452010);
        add2.setID(++id);
        add2.setStudentId(2);
        addressObj.add(add2);

        Address add3 = new Address();
        add3.setCity("Ujjain");
        add3.setPinCode(456001);
        add3.setID(++id);
        add3.setStudentId(3);
        addressObj.add(add3);

        Address add4 = new Address();
        add4.setCity("Mumbai");
        add4.setPinCode(400001);
        add4.setID(++id);
        add4.setStudentId(4);
        addressObj.add(add4);

        Address add5 = new Address();
        add5.setCity("Indore");
        add5.setPinCode(452011);
        add5.setID(++id);
        add5.setStudentId(5);
        addressObj.add(add5);

        List<Class> classObj = new ArrayList<>();// holds Class Objects
        int ClassID = 0;

        Class cl1 = new Class();
        cl1.setId(++ClassID);
        cl1.setCls("A");
        classObj.add(cl1);

        Class cl2 = new Class();
        cl2.setId(++ClassID);
        cl2.setCls("B");
        classObj.add(cl2);

        Class cl3 = new Class();
        cl3.setId(++ClassID);
        cl3.setCls("C");
        classObj.add(cl3);

        Class cl4 = new Class();
        cl4.setId(++ClassID);
        cl4.setCls("D");
        classObj.add(cl4);

        Class cl5 = new Class();
        cl5.setId(++ClassID);
        cl5.setCls("B");
        classObj.add(cl5);
        Collections.sort(stuObj, Comparator.comparingInt(Student::getMarks).reversed());// Sorting Students in descending order based on marks

        //Writing Collections in File
        FileOperation op1 =new FileOperation();
        op1.FileCreation();
        op1.RankersFileCreation();
        op1.writeFile(stuObj, addressObj, classObj);
        op1.writeInRankfile(stuObj);

        Scanner sc = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("What operation do you like to perform: \n1. INSERT \n2. VIEW \n3. DELETE\n4. Top Rankers\n5. Exit");
            int n = 0;
            boolean inputCheck = true;
            while(inputCheck) {
                try {
                    n = sc.nextInt();
                    sc.nextLine();
                    inputCheck =false;
                } catch (InputMismatchException e) {
                    System.out.println("Only Integer allowed Please Try Again");
                    sc.nextLine();
                }
            }
            String name = "";
            switch (n) {
                case 1:
                    int marks;
                    String gender = "";
                    int age ;
                    System.out.println("Enter Student Details in the below order");
                    Student s1 = new Student();
                    Address a1 = new Address();
                    Class c1 = new Class();

                    System.out.println("name, gender, marks, age");

                    name = sc.nextLine();
                    gender = sc.nextLine();

                    boolean checkMarks = true;
                    while(checkMarks){
                        marks = sc.nextInt();
                        try {
                            s1.setMarks(marks);
                            checkMarks =false;
                        }catch (InvalidMarksException e){
                            System.out.println("Exception caught: " + e.getMessage());
                        }
                    }
                    boolean checkAge = true;
                    while(checkAge){
                        age = sc.nextInt();
                        try {
                            s1.setAge(age);
                            checkAge =false;
                        }
                        catch (InvalidAgeException e){
                            System.out.println("Exception caught :" + e.getMessage());
                        }
                    }
                    s1.setName(name);
                    s1.setGender(gender);


                    s1.setClassId(++ClassID);
                    c1.setId(ClassID);
                    s1.setId(++id);
                    a1.setStudentId(id);
                    stuObj.add(s1);

                    System.out.println("Enter Address Details in same order: City, Pincode");
                    String city = "";
                    try {
                         city = sc.next();
                        sc.nextLine();
                    }catch (InputMismatchException e){
                        System.out.println("City must be in string " + e);
                    }

                    int pincodes = sc.nextInt();

                    a1.setCity(city);
                    a1.setPinCode(pincodes);
                    addressObj.add(a1);

                    System.out.println("Enter Class");
                    String clss = sc.next();
                    sc.nextLine();
                    c1.setCls(clss);
                    classObj.add(c1);

                    Collections.sort(stuObj, Comparator.comparingInt(Student::getMarks).reversed());// Sorting Students in descending order based on marks
                    op1.writeInRankfile(stuObj);
                    break;

                case 2:
                    System.out.println("1.BY NAME\n2.BY CITY\n3.BY PINCODE");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    boolean check = true;
                    switch (choice) {
                        case 1:
                            System.out.println("Enter student name: ");
                            name = sc.nextLine();
                            for (Student s : stuObj) {
                                if (s.getName().equalsIgnoreCase(name)) {
                                    System.out.println(s);
                                    for (Address ad : addressObj) {
                                        if (ad.getStudentId() == (s.getId())) {
                                            System.out.println(ad);
                                            check = false;
                                        }
                                    }
                                    for (Class cl : classObj) {
                                        if (cl.getId() == (s.getClassId()))
                                            System.out.println(cl);
                                    }
                                }
                            }
                            if (check) {
                                System.out.println("No record found.");
                            }
                            break;
                        case 2:
                            System.out.println("Enter City Name: ");
                            String cityName = sc.nextLine();
                            int stuId = 0;
                            for (Address ad : addressObj) {
                                if (ad.getCity().equalsIgnoreCase(cityName)) {
                                    for (Student s : stuObj) {
                                        if (s.getId() == (ad.getStudentId())) {
                                            System.out.println(s + "\n" + ad);
                                            stuId = s.classId;
                                            check = false;
                                        }
                                    }
                                    for (Class cl : classObj) {
                                        if (cl.getId() == stuId)
                                            System.out.println(cl);
                                    }
                                }
                            }
                            if (check)
                                System.out.println("No record found.");
                            break;
                        case 3:
                            check = true;
                            System.out.println("Enter Pincode: ");
                            int pincode = sc.nextInt();
                            sc.nextLine();
                            int stu_Id = 0;
                            for (Address ad : addressObj) {
                                if (ad.getPinCode() == (pincode)) {
                                    for (Student s : stuObj) {
                                        if (s.getId() == (ad.getStudentId())) {
                                            System.out.println(s + "\n" + ad);
                                            stuId = s.classId;
                                            check = false;
                                        }
                                    }
                                    for (Class cl : classObj) {
                                        if (cl.getId() == stu_Id)
                                            System.out.println(cl);
                                    }
                                }
                            }
                            if (check)
                                System.out.println("No record found.");
                            break;
                        default:
                            System.out.println("Invalid Input");
                    }
                    break;
                case 3:
                    System.out.println("Enter student name: ");
                    String name2 = sc.nextLine();
                    List<Student> studentDelete = stuObj.stream().filter(a -> a.getName().equals(name2)).collect(Collectors.toList());
                    System.out.println(studentDelete);

                    if (studentDelete.isEmpty()) {
                        System.out.println("No record found for: " + name2);
                    } else {
                        for (Student sd : studentDelete) {
                            stuObj.remove(sd);
                        }
                        System.out.println(name2 + "'s Record deleted.");
                    }
                    System.out.println(name + "'s Record deleted.");
                    break;

                case 4:
                    System.out.println("Top 3 Rankers");
                    Collections.sort(stuObj, Comparator.comparingInt(Student::getMarks).reversed());// Sorting Students in descending order based on marks
                    op1.readRankFile();

                case 5:
                    exit = true;
                    System.out.println("Thank You!🤗");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
} 