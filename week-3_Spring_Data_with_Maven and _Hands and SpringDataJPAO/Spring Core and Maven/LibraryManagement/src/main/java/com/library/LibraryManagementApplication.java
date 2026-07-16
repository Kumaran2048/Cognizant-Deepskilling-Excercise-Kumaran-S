package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        System.out.println("[LibraryManagementApplication] Starting context load...");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("[LibraryManagementApplication] Spring Context loaded successfully.");

        BookService bookService = (BookService) context.getBean("bookService");

        bookService.registerBook("Spring Framework Essentials");

        System.out.println("[LibraryManagementApplication] Finished test execution.");
    }
}
