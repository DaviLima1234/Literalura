package com.alura.literalura.service;


import com.alura.literalura.model.Book;
import com.alura.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookService {

    private final RestTemplate restTemplate;
    private final BookRepository bookRepository;

    @Autowired
    public BookService(RestTemplate restTemplate, BookRepository bookRepository) {
        this.restTemplate = restTemplate;
        this.bookRepository = bookRepository;
    }

    public Book getBookById(Long id) {
        String url = "http://api.example.com/books/{id}";
        return restTemplate.getForObject(url, Book.class, id);
    }

    public void saveBook(Book book) {
        String url = "http://api.example.com/books";
        restTemplate.postForObject(url, book, Book.class);
    }

    public void updateBook(Book book) {
        String url = "http://api.example.com/books/{id}";
        restTemplate.put(url, book, book.getId());
    }

    public void deleteBook(Long id) {
        String url = "http://api.example.com/books/{id}";
        restTemplate.delete(url, id);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> findBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }
}
