package di.controller;

import di.model.Accident;
import di.model.User;
import di.repository.AuthorityRepository;
import di.repository.UserRepository;
import di.service.AccidentService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
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
//    private final UserRepository users;
//    private final AuthorityRepository authorities;
    private final AccidentService service;

    public RegControl(PasswordEncoder encoder, AccidentService service) {
        this.encoder = encoder;
        this.service = service;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(service.findByAuthority("ROLE_USER"));
        service.saveOrEdit(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String reg(@ModelAttribute Accident accident) {
        return "reg";
    }
}
