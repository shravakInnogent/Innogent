package com.libraryManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.IdGeneratorType;

import java.util.List;

@Entity
@Data
@Table(name = "Books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;

    @Column
    String bookTitle;

    @Column
    String bookAuthor;

    @Column
    String description;

    @Column(nullable = false)
    private Integer stock = 0;

    @Column(nullable = false)
    Integer totalCopies = 0;


    @ManyToMany
    @JoinTable(name = "books_member",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns=@JoinColumn(
            name = "member_id"))
    @JsonIgnore
    private List<Member> members;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    @JsonIgnore
    private Author author;

}
