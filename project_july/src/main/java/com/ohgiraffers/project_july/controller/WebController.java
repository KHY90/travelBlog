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

        // 임시로 아무 값을 입력해도 로그인 성공으로 처리
        // 실제 개발에서는 이 부분을 데이터베이스 조회 등의 실제 로그인 로직으로 대체해야 합니다.
        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            // 로그인 성공 시
            attributes.addFlashAttribute("loginSuccess", true); // 로그인 성공 여부를 Flash 속성으로 전달
            return "redirect:/index.html"; // 정적 리소스인 index.html 페이지로 리다이렉트
        } else {
            // 로그인 실패 시
            attributes.addFlashAttribute("loginError", true); // 로그인 실패 여부를 Flash 속성으로 전달
            return "redirect:/menu-login"; // 로그인 페이지로 리다이렉트 (오류 메시지 포함 가능)
        }
    }

    // 회원가입 페이지로 이동
    @GetMapping("/signup")
    public String signupPage() {
        return "signup"; // templates/signup.html 템플릿을 반환
    }
}
