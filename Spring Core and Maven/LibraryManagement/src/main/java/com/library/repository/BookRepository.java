package com.library.repository;

public class BookRepository {
    public void saveBook(String title) {
        System.out.println("[BookRepository] Successfully saved book to repository: " + title);
    }
}
