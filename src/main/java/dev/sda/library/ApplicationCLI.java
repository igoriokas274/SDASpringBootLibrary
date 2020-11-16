package dev.sda.library;

import dev.sda.library.dao.AuthorRepository;
import dev.sda.library.entity.Author;
import dev.sda.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationCLI implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationCLI.class, args);
	}

	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public void run(String... args) throws Exception {


		Author theAuthor1 = new Author("John", "Doe");
		Author theAuthor2 = new Author("Petras", "Petraitis");
		Author theAuthor3 = new Author("Herodotus");
		Author theAuthor4 = new Author("Homer");

		Book theBook1 = new Book("Secret Book");
		Book theBook2 = new Book("Peter's Custom Book");
		Book theBook3 = new Book("The Histories");
		Book theBook4 = new Book("Iliad");
		Book theBook5 = new Book("Odyssey");

		theAuthor1.getBooks().add(theBook1);
		theAuthor2.getBooks().add(theBook2);
		theAuthor3.getBooks().add(theBook3);
		theAuthor4.getBooks().add(theBook4);
		theAuthor4.getBooks().add(theBook5);

		theBook1.getAuthors().add(theAuthor1);
		theBook2.getAuthors().add(theAuthor2);
		theBook3.getAuthors().add(theAuthor3);
		theBook4.getAuthors().add(theAuthor4);
		theBook5.getAuthors().add(theAuthor4);

		this.authorRepository.save(theAuthor1);
		this.authorRepository.save(theAuthor2);
		this.authorRepository.save(theAuthor3);
		this.authorRepository.save(theAuthor4);

	}
}
