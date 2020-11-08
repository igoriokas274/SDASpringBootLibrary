package dev.sda.library.service;

import dev.sda.library.entity.Author;

import java.util.List;

public interface AuthorService {

    public List<Author> findAll();

    public Author findById(long authorId);

    public void save(Author theAuthor);

    public void deleteById(long authorId);

}
