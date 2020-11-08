package dev.sda.library.service;

import dev.sda.library.dao.AuthorRepository;
import dev.sda.library.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl (AuthorRepository theAuthorRepository) {
        authorRepository = theAuthorRepository;
    }

    @Override
    public List<Author> findAll() {
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
