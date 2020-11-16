package dev.sda.library.service;

import dev.sda.library.dao.AuthorRepository;
import dev.sda.library.dao.BookRepository;
import dev.sda.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    private AuthorRepository authorRepository;

    @Autowired
    public BookServiceImpl (BookRepository theBookRepository, AuthorRepository theAuthorRepository) {
        bookRepository = theBookRepository;
        authorRepository = theAuthorRepository;
    }

    @Override
    public Set<Book> findAll() {
        return bookRepository.findAllByOrderByTitleAsc();
    }

    @Override
    public Book findById(long bookId) {

        Optional<Book> result = bookRepository.findById(bookId);

        Book theBook = null;

        if (result.isPresent()) {
            theBook = result.get();
        } else {
            throw new RuntimeException("Did not find book id - " + bookId);
        }

        return theBook;
    }

    @Override
    public void save(Book theBook) {
        bookRepository.save(theBook);
    }

    @Override
    public void deleteById(long bookId) {
        bookRepository.deleteById(bookId);
    }
}
