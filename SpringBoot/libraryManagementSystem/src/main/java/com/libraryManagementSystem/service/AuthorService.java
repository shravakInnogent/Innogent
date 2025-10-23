package com.libraryManagementSystem.service;

import com.libraryManagementSystem.Exception.AuthorNotFoundException;
import com.libraryManagementSystem.entity.Author;
import com.libraryManagementSystem.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorService {

    @Autowired
    AuthorRepo authorRepo;

    public void add(Author author)
    {
        authorRepo.save(author);
    }
//    public Author getAuthor(long id){
//        try {
//            return authorRepo.findById(id).get();
//        } catch (NoSuchElementException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public Author getAuthor(Long id) {
        return authorRepo.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
    }
}
