package com.projectsfortraining.bookproject.controllers;

import com.projectsfortraining.bookproject.dao.BookDAO;
import com.projectsfortraining.bookproject.dao.PersonDAO;
import com.projectsfortraining.bookproject.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;
    private final BookDAO bookDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO, BookDAO bookDAO){
        this.personDAO = personDAO;
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String showAll(Model model){
        model.addAttribute("people", personDAO.readAll());
        return "/people/show";
    }

    @GetMapping("/{id}")
    public String showOne(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.readOne(id));
        model.addAttribute("books", bookDAO.readByPersonId(id));
        return "people/person";
    }

    @GetMapping("/new")
    public String addPerson(@ModelAttribute("person") Person newPerson){
        return "people/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("person") Person newPerson){
        personDAO.create(newPerson);
        return "/people/show";
    }



}
