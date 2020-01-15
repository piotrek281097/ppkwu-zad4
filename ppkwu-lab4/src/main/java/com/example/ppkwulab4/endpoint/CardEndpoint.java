package com.example.ppkwulab4.endpoint;


import com.example.ppkwulab4.model.Person;
import com.example.ppkwulab4.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/api/")
public class CardEndpoint {

    private CardService cardService;

    @Autowired
    public CardEndpoint(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("browser")
    public ModelAndView setSearch() {
        return new ModelAndView("search", "person", new Person());
    }

    @PostMapping("search")
    public String searchEmployee(@Valid @ModelAttribute("person") Person person, ModelMap model) throws IOException {
        List<Person> people = cardService.getPeopleByName(person.getName());
        model.addAttribute("nameGivenByUser", person.getName());
        model.addAttribute("people", people);

        return "result";
    }

    @PostMapping("generate-vcard/{nameGivenByUser}/{index}")
    public ResponseEntity<Resource> generateVCard(@PathVariable String nameGivenByUser, @PathVariable int index) throws IOException {
        return cardService.generateVCard(nameGivenByUser, index);
    }
}
