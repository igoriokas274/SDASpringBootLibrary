package dev.sda.library.dao;

import dev.sda.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> findAllByOrderByTitleAsc();

}
