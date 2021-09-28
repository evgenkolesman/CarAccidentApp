package di.controller;

import di.repository.AccidentJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



/**
 *  Вот так бы было через AccidentMem
 *  @GetMapping("/")
 *   public String index(Model model) {
 *        model.addAttribute("accidents", new AccidentService(new AccidentMem()).getAll());
 *       return "index";
 *   }
 */
@Controller
public class IndexControl {

    private final AccidentJdbcTemplate accidents;

    public IndexControl(AccidentJdbcTemplate accidents) {
        this.accidents = accidents;
    }



    @GetMapping
    public String index(Model model) {
        model.addAttribute("accidents", accidents.getAllAccident());
        return "index";
    }
}
