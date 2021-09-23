package di.controller;

import di.model.Accident;
import di.repository.AccidentMem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class IndexControl {

    @GetMapping("/")
    public String index(Model model) {
        AccidentMem store = new AccidentMem();
        store.add(1, new Accident(1, "NAME", "DESC", "STREET им. Жукова"));
        store.add(2, new Accident(2, "NAME1", "DESC1", "STREET Майская"));
        List<Accident> list = store.getAll().stream().toList();
        model.addAttribute("accidents", list);
        return "index";
    }
}
