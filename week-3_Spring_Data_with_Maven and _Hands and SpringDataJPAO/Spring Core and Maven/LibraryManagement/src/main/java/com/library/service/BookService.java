package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void registerBook(String title) {
        System.out.println("[BookService] Registering book: " + title);
        if (bookRepository != null) {
            bookRepository.saveBook(title);
        } else {
            System.err.println("[BookService] Dependency Injection Failed! bookRepository is null.");
        }
    }
}
