package se.ecutb.hala.mvc_excersice_thymeleaf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.ecutb.hala.mvc_excersice_thymeleaf.data.PersonDao;
import se.ecutb.hala.mvc_excersice_thymeleaf.entity.Person;

import java.time.LocalDate;

@Controller
public class Home {

    private PersonDao personDao;

    @Autowired
    public Home(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/contact")
    public String contact(@RequestParam(value = "contacts",required = false) Model model){
       // model.addAttribute("contacts", personDao.findAll());
      return "contact-form";
    }

    @PostMapping("/contact")
    public String contact(@RequestParam("name") String name,
                          @RequestParam("email") String email,
                          @RequestParam("birthDate") LocalDate birthDate,
                          @RequestParam("gender") String gender){
        personDao.save(new Person(name,email,birthDate,gender));
        return "redirect:/contact-list";
    }

    @GetMapping("/contact-list")
    public String contactList(Model model){
        model.addAttribute("contacts",personDao.findAll());
        return "contact-list";
    }

    @GetMapping("contact/find")
    public String findById(@RequestParam("id") int id, Model model){
        Person person = personDao.findById(id).get();
        model.addAttribute("contact",person);
        return "contact-details";
    }

    @PostMapping("contact/delete")
    public String delete(@RequestParam("id") int id){
        personDao.delete(id);
        return "redirect:/contact-list";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
