package di.controller;

import di.model.Accident;
import di.repository.AccidentHibernate;
import di.repository.AccidentJdbcTemplate;
import di.repository.AccidentRepository;
import di.service.AccidentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


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
 *     \
 *
 *     Вот так для чистого Hibernate
 *
 *
 *         private final AccidentService accidents;
 *
 *     public IndexControl(AccidentService accidents) {
 *         this.accidents = accidents;
 *     }
 *
 *
 *
 *     @GetMapping
 *     public String index(Model model) {
 *         model.addAttribute("accidents", accidents.getAll());
 *         return "index";
 *     }
 */
@Controller
public class IndexControl {

    private final AccidentService accidents;

    public IndexControl(AccidentService accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Accident> res = new ArrayList<>();
        accidents.getAll().forEach(res::add);
        model.addAttribute("accidents", res);
        return "index";
    }
}
