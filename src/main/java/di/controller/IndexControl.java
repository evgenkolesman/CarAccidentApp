package di.controller;

import di.model.Accident;
import di.repository.AccidentHibernate;
import di.repository.AccidentJdbcTemplate;
import di.repository.AccidentRepository;
import di.service.AccidentService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Main controller
 * for the face page
 *
 * under methods there are JavaDocs with another ways of using it
 */
@Controller
public class IndexControl {

    private final AccidentService accidents;

    public IndexControl(AccidentService accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("accidents", accidents.getAll());
        return "index";
    }
}

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