package ru.gogogo.glhf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gogogo.glhf.DAO.PeopleDAO;
import ru.gogogo.glhf.model.Person;

@Controller
@RequestMapping("/x")
public class PeopleController {
    @Autowired
    private PeopleDAO peopleDAO;

    @GetMapping
    public String index(Model model){
        model.addAttribute("people",peopleDAO.index());
        return "x/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,Model model){
        model.addAttribute("person",peopleDAO.show(id));
        return "x/show";
    }

    @GetMapping("/new")
    public String gocreate(Model model){
        model.addAttribute("person",new Person());
        return "x/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") Person person) {
        peopleDAO.save(person);
        return "redirect:/x";
    }

    @GetMapping("/{id}/edit")
    public String goedit(Model model,@PathVariable("id") int id){
        model.addAttribute("person", peopleDAO.show(id));
        return "x/edit";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("person") Person person,@PathVariable("id") int id){
        peopleDAO.edit(person,id);
        return "redirect:/x";
    }


    @DeleteMapping("/{id}/delete")
    public String godelete(@PathVariable("id")int id){
        peopleDAO.delete(id);
        return "redirect:/x";
    }
}
