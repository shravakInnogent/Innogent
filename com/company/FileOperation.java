package com.company;

import java.io.*;
import java.util.List;

class FileOperation {
    void FileCreation() {
        File fop = new File("student.csv");
        try {
            if (fop.createNewFile()) {
                System.out.println("File Created " + fop.getName());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    void RankersFileCreation() {
        File fopr = new File("RankHolderStudent.csv");
        try {
            if (fopr.createNewFile()) {
                System.out.println("File Created " + fopr.getName());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    void writeInRankfile(List<Student> rankers) {
        try {
            FileOutputStream fosr = new FileOutputStream("RankHolderStudent.csv");
            ObjectOutputStream oosr = new ObjectOutputStream(fosr);
            oosr.writeObject(rankers.get(0));
            oosr.writeObject(rankers.get(1));
            oosr.writeObject(rankers.get(2));
        } catch (IOException e) {
            System.out.println("File not found");
        }

    }

    void writeFile(List<Student> sObj, List<Address> aObj, List<Class> cObj) {
        try {
            FileOutputStream fos = new FileOutputStream("student.csv");
            ObjectOutputStream oops = new ObjectOutputStream(fos);
            for (Student s : sObj) {
                oops.writeObject(s);
            }
            for (Address a : aObj) {
                oops.writeObject(a);
            }

            for (Class c : cObj) {
                oops.writeObject(c);
            }
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }

    void readFile() {
        Student s1 = null;
        try {
            FileInputStream fis = new FileInputStream("student.csv");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (Student) ois.readObject();
            System.out.println(s1);
        } catch (ClassNotFoundException ec) {
            System.out.println(ec);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    void readRankFile() {
        Student s1 = null;
        Student s2 = null;
        Student s3 = null;
        try {
            FileInputStream fisr = new FileInputStream("RankHolderStudent.csv");
            ObjectInputStream ois = new ObjectInputStream(fisr);
            s1 = (Student) ois.readObject();
            System.out.println(s1);
            s2 = (Student) ois.readObject();
            System.out.println(s2);
            s3 = (Student) ois.readObject();
            System.out.println(s3);
        } catch (ClassNotFoundException ec) {
            System.out.println(ec);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
