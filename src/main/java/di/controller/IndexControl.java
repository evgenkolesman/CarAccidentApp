package di.controller;

import di.repository.AccidentHibernate;
import di.repository.AccidentJdbcTemplate;
import di.service.AccidentService;
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
 *   Вот так AccidentJdbcTemplate
 *
 *   private final AccidentJdbcTemplate accidents;
 *
 *     public IndexControl(AccidentJdbcTemplate accidents) {
 *         this.accidents = accidents;
 *     }
 *
 *
 *
 *     @GetMapping
 *     public String index(Model model) {
 *         model.addAttribute("accidents", accidents.getAllAccident());
 *         return "index";
 *     }
 */
@Controller
public class IndexControl {

    private final AccidentService accidents;

    public IndexControl(AccidentService accidents) {
        this.accidents = accidents;
    }



    @GetMapping
    public String index(Model model) {
        model.addAttribute("accidents", accidents.getAll());
        return "index";
    }
}
