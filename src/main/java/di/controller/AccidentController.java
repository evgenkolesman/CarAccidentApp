package di.controller;

import di.model.Accident;
import di.model.AccidentType;
import di.repository.AccidentMem;
import di.service.AccidentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccidentController {

    private final AccidentService service;
    private List<AccidentType> types = new ArrayList<>();

    {
        types.add(AccidentType.of(1, "Две машины"));
        types.add(AccidentType.of(2, "Машина и человек"));
        types.add(AccidentType.of(3, "Машина и велосипед"));
    }

    public AccidentController(AccidentService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", types);
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        service.saveOrEdit(accident);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("types", types);
        model.addAttribute("accident", service.get(id));
        return "/update";
    }

}
