package dev.sda.library.dao;

import dev.sda.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    public Set<Author> findAllByOrderByLastNameAsc();

}
