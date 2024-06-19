package com.ohgiraffers.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlanController {

    @GetMapping("/plan")
    public String plan(ModelAndView mv) {

        return "plan";
    }


}
