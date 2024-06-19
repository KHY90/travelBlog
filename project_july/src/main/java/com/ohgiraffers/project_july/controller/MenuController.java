package com.ohgiraffers.project_july.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/invite")
    public String menuInvite(Model model) {
        model.addAttribute("pageInvite", "Menu Invite Page");
        return "menu/menu-invite";
    }

    @GetMapping("/menu-plan")
    public String menuPlan(Model model) {
        model.addAttribute("pagePlan", "Menu Plan Page");
        return "menu/menu-plan";
    }

    @GetMapping("/menu-review")
    public String menuReview(Model model) {
        model.addAttribute("pageReview", "Menu Review Page");
        return "menu/menu-review";
    }
}
