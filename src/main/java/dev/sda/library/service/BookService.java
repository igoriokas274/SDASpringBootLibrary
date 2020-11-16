package dev.sda.library.service;

import dev.sda.library.entity.Book;

import java.util.Set;

public interface BookService {

    public Set<Book> findAll();

    public Book findById(long bookId);

    public void save(Book theBook);

    public void deleteById(long bookId);

}
