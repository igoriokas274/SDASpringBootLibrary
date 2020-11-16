package dev.sda.library.service;

import dev.sda.library.dao.AuthorRepository;
import dev.sda.library.dao.BookRepository;
import dev.sda.library.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    @Autowired
    public AuthorServiceImpl (AuthorRepository theAuthorRepository, BookRepository theBookRepository ) {
        authorRepository = theAuthorRepository;
        bookRepository = theBookRepository;
    }

    @Override
    public Set<Author> findAll() {
        return authorRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Author findById(long authorId) {

        Optional<Author> result = authorRepository.findById(authorId);

        Author theAuthor = null;

        if (result.isPresent()) {
            theAuthor = result.get();
        } else {
            throw new RuntimeException("Did not find author id - " + authorId);
        }

        return theAuthor;
    }

    @Override
    public void save(Author theAuthor) {
        authorRepository.save(theAuthor);
    }

    @Override
    public void deleteById(long authorId) {
        authorRepository.deleteById(authorId);
    }
}
