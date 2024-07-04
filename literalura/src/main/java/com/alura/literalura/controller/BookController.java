package com.alura.literalura.controller;

import com.alura.literalura.model.Book;
import com.alura.literalura.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return book != null ? book.toString() : "Book not found";
    }

    @GetMapping
    public List<Book> getBooksByLanguage(@RequestParam(required = false) String language) {
        if (language != null) {
            return bookService.findBooksByLanguage(language);
        } else {
            return bookService.findAllBooks();
        }
    }


}
