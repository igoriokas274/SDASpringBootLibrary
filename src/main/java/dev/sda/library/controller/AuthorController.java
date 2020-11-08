package dev.sda.library.controller;

import dev.sda.library.entity.Author;
import dev.sda.library.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService theAuthorService) {
        authorService = theAuthorService;
    }

    @GetMapping("/list")
    public String listAuthors(Model theModel) {

        List<Author> theAuthors = authorService.findAll();

        theModel.addAttribute("authors", theAuthors);

        return "authors/list-authors";
    }

    @GetMapping("/showFormForAddAuthor")
    public String showFormForAddAuthor(Model theModel) {

        Author theAuthor = new Author();

        theModel.addAttribute("author", theAuthor);

        return "authors/author-form";
    }

    @GetMapping("/showFormForUpdateAuthor")
    public String showFormForUpdateAuthor(@RequestParam("authorId") int theId, Model theModel) {

        Author theAuthor = authorService.findById(theId);

        theModel.addAttribute("author", theAuthor);

        return "authors/author-form";
    }

    @PostMapping("/saveAuthor")
    public String saveAuthor(@ModelAttribute("author") Author theAuthor) {

        authorService.save(theAuthor);

        return "redirect:/authors/list";
    }

    @GetMapping("/deleteAuthor")
    public String deleteAuthor(@RequestParam("authorId") int theId) {

        authorService.deleteById(theId);

        return "redirect:/authors/list";
    }
}
