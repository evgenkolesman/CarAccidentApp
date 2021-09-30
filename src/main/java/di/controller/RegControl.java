package di.controller;

import di.model.Accident;
import di.model.User;
import di.repository.AuthorityRepository;
import di.repository.UserRepository;
import di.service.AccidentService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Registration controller
 * it gets
 * PasswordEncoder encoder we use for encode words
 * UserRepository users we use for Users store
 * AuthorityRepository authorities we use for Authorities store
 */
@Controller
public class RegControl {

    private final PasswordEncoder encoder;
    private final AccidentService service;

    public RegControl(PasswordEncoder encoder, AccidentService service) {
        this.encoder = encoder;
        this.service = service;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user, Model model) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(service.findByAuthority("ROLE_USER"));
        if (service.findUserById(user.getId()) == null && service.findUserByName(user.getUsername()) == null) {
            service.saveOrEdit(user);
        } else {
            model.addAttribute("errorMessage", "Please try to register with another Username");
            return "reg";
        }
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String reg(@ModelAttribute Accident accident) {
        return "reg";
    }
}
