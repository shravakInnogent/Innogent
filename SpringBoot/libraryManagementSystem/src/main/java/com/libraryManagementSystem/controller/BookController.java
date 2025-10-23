package com.libraryManagementSystem.controller;


import com.libraryManagementSystem.Dto.BookRequestDto;
import com.libraryManagementSystem.Dto.BorrowRequestDto;
import com.libraryManagementSystem.entity.Books;
import com.libraryManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public void addBook(@RequestBody BookRequestDto bookRequestDto){
        bookService.addBook(bookRequestDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable long id){
        bookService.deleteBook(id);
    }

    @GetMapping("/getBookById/{id}")
    public Books getBookById(@PathVariable long id){
        return bookService.getBookById(id);
    }

    @PutMapping("/updateBook/{id}")
    public void updateBook(@RequestBody Books book ,@PathVariable long id){
        bookService.updateBook(id, book);
    }

    @GetMapping("/available")
    public ResponseEntity<List<BookRequestDto>> getAvailableBooks() {
        return ResponseEntity.ok(bookService.getAvailableBooks());
    }

    @PostMapping("/borrow")
    public ResponseEntity<String> borrowBook(@RequestBody BorrowRequestDto request) {
        String message = bookService.borrowBook(request.getMemberId(), request.getBookId());
        return ResponseEntity.ok(message);
    }

    @PostMapping("/return")
    public ResponseEntity<String> returnBook(@RequestBody BorrowRequestDto request) {
        String message = bookService.returnBook(request.getMemberId(), request.getBookId());
        return ResponseEntity.ok(message);
    }
}
