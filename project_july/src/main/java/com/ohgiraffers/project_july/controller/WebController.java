package com.ohgiraffers.project_july.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WebController {

    // 로그인 페이지로 이동
    @GetMapping("/menu-login")
    public String loginPage() {
        return "menu/menu-login"; // menu-login.html 템플릿을 반환
    }

    // 로그인 처리
    @PostMapping("/menu-login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        RedirectAttributes attributes) {

        // 여기에 실제 로그인 로직을 구현합니다.
        // 예를 들어, 임시로 "admin" / "password"로 로그인 성공 처리하는 예시입니다.
        if ("admin".equals(username) && "password".equals(password)) {
            // 로그인 성공 시 리다이렉트 및 세션 처리 등을 수행합니다.
            attributes.addFlashAttribute("loginSuccess", true); // 로그인 성공 여부를 Flash 속성으로 전달
            return "redirect:/"; // 메인 페이지로 리다이렉트
        } else {
            // 로그인 실패 시 리다이렉트 및 오류 메시지 전달
            attributes.addFlashAttribute("loginError", true); // 로그인 실패 여부를 Flash 속성으로 전달
            return "redirect:/"; // 로그인 페이지로 리다이렉트 (오류 메시지 포함 가능)
        }
    }

    // 회원가입 페이지로 이동
    @GetMapping("/signup")
    public String signupPage() {
        return "signup"; // 추후 구현 예정
    }
}
