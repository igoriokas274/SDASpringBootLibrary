package dev.sda.library.controller;

import dev.sda.library.entity.Author;
import dev.sda.library.entity.Book;
import dev.sda.library.service.AuthorService;
import dev.sda.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    private AuthorService authorService;

    @Autowired
    public BookController(BookService theBookService, AuthorService theAuthorService) {

        bookService = theBookService;
        authorService = theAuthorService;
    }

    @GetMapping("/list")
    public String listBooks(Model theModel) {

        Set<Book> theBook = bookService.findAll();
        Set<Author> theAuthor = authorService.findAll();
        theModel.addAttribute("books", theBook);
        theModel.addAttribute("author", theAuthor);
        return "books/list-books";
    }

    @GetMapping("/showFormForAddBook")
    public String showFormForAddBook(Model theModel) {

        Book theBook = new Book();

        theModel.addAttribute("book", theBook);
        Set<Author> theAuthor = authorService.findAll();
        theModel.addAttribute("author", theAuthor);

        return "books/book-form";
    }

    @GetMapping("/showFormForUpdateBook")
    public String showFormForUpdateBook(@RequestParam("bookId") int theId, Model theModel) {

        Book theBook = bookService.findById(theId);
        theModel.addAttribute("book", theBook);
        Set<Author> theAuthor = authorService.findAll();
        theModel.addAttribute("author", theAuthor);

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

    @GetMapping("/showBooksByAuthor")
    public String showBooksByAuthor(@RequestParam("authorId") int authorId, Model theModel) {

        Author theAuthor = authorService.findById(authorId);
        Set<Book> theBooks = theAuthor.getBooks();
        theModel.addAttribute("author", theAuthor);
        theModel.addAttribute("books", theBooks);

        return "books/ShowBooksByAuthorId";
    }

    @GetMapping("/addBookToAuthor")
    public String addBookToAuthor(@RequestParam("authorId") int authorId, Model theModel) {

        Book theBook = new Book();

        Author theAuthor = authorService.findById(authorId);
        theModel.addAttribute("book", theBook);
        theModel.addAttribute("author", theAuthor);

        return "books/book-form";
    }
}
