package com.innogent.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;


@Table(name = "STUDENT")
@Data
@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Integer id ;
    String name;
    String email;
}
