package csc340.example.indiv_four;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping({"", "/", "/home", "/index"})
    public String home(){
        return "redirect:/goals/all";
    }
}
