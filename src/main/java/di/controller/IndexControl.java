package di.controller;

import di.model.Accident;
import di.repository.AccidentMem;
import di.service.AccidentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class IndexControl {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", new AccidentService(new AccidentMem()).getAll());
        return "index";
    }
}
