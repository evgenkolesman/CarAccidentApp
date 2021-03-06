package di.controller;

import di.model.Accident;
import di.model.AccidentType;
import di.model.Rule;
import di.repository.AccidentMem;
import di.service.AccidentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Accident controller
 * with some of CRUD operation
 */
@Controller
public class AccidentController {

    private final AccidentService service;

    public AccidentController(AccidentService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", service.getTypes());
        model.addAttribute("rules", service.getRules());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        String[] type = req.getParameterValues("type.id");
        accident.setRule(service.getRule(ids));
        accident.setType(service.getType(type));
        service.saveOrEdit(accident);
        return "redirect:/";
    }

    @GetMapping("/save")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("types", service.getTypes());
        model.addAttribute("rules", service.getRules());
        model.addAttribute("accident", service.get(id));
        return "/update";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id") int id) {
        service.deleteAccidentById(id);
        return "redirect:/";
    }
}
