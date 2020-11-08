package dev.sda.library.controller;

import dev.sda.library.entity.Book;
import dev.sda.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService theBookService) {
        bookService = theBookService;
    }

    @GetMapping("/list")
    public String listBooks(Model theModel) {

        List<Book> theBook = bookService.findAll();

        theModel.addAttribute("books", theBook);

        return "books/list-books";
    }

    @GetMapping("/showFormForAddBook")
    public String showFormForAddBook(Model theModel) {

        Book theBook = new Book();

        theModel.addAttribute("book", theBook);

        return "books/book-form";
    }

    @GetMapping("/showFormForUpdateBook")
    public String showFormForUpdateBook(@RequestParam("bookId") int theId, Model theModel) {

        Book theBook = bookService.findById(theId);

        theModel.addAttribute("book", theBook);

        return "books/book-form";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book theBook) {

        bookService.save(theBook);

        return "redirect:/books/list";
    }

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookId") int theId) {

        bookService.deleteById(theId);

        return "redirect:/books/list";
    }
}
