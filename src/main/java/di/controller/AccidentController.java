package di.controller;

import di.model.Accident;
import di.model.AccidentType;
import di.model.Rule;
import di.repository.AccidentMem;
import di.service.AccidentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AccidentController {

    private final AccidentService service;

    public AccidentController(AccidentService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", AccidentService.getTypes());
        model.addAttribute("rules", AccidentService.getRules());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        String[] type = req.getParameterValues("type.id");
        accident.setRule(AccidentService.getRules().stream().filter(x -> x.getId() == Integer.parseInt(ids[0])).findFirst().get());
        accident.setType(AccidentService.getTypes().stream().filter(x -> x.getId() == Integer.parseInt(type[0])).findFirst().get());
        service.saveOrEdit(accident);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("types", AccidentService.getTypes());
        model.addAttribute("rules", AccidentService.getRules());
        model.addAttribute("accident", service.get(id));
        return "/update";
    }
}
