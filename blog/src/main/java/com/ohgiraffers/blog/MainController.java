package com.ohgiraffers.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/share")
    public String share() {
        return "share/share";
    }

    @GetMapping("/plan")
    public String plan() {
        return "plan/plan";
    }

    @GetMapping("/map")
    public String map() {
        return "plan/map";
    }

}
