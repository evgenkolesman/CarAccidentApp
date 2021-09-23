package di.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.IntStream;

@Controller
public class IndexControl {

    static List <String> mainList = new ArrayList<>();
    @GetMapping("/")
    public String index(Model model) {
        List<String> list = new ArrayList<>();
        model.addAttribute("user", "Evgen Evgenov");

        for (int s = 1; s <= 5; s++) {
            list.add("user" + s);
        }
        model.addAttribute("users", list);
        return "index";
    }

//    public static void main(String[] args) {
//        for (int s = 1; s <= 5; s++) {
//            mainList.add("user" + s);
//        }
//       IntStream.range(0, mainList.size()).forEach(s -> System.out.println(mainList.get(s)));
//    }
}
