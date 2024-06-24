package com.ohgiraffers.project_july.controller;

import org.springframework.stereotype.Controller;
<<<<<<< HEAD
=======
import org.springframework.ui.Model;
>>>>>>> ba6e39098d27fbb7cf38ef40ffcf775f0785289d
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
<<<<<<< HEAD
=======
import org.springframework.web.bind.support.SessionStatus;
>>>>>>> ba6e39098d27fbb7cf38ef40ffcf775f0785289d

@Controller
public class WebController {

    // 로그인 페이지로 이동
    @GetMapping("/menu-login")
    public String loginPage() {
<<<<<<< HEAD
        return "menu/menu-login"; // menu-login.html 템플릿을 반환
=======
        return "menu/menu-login"; // templates/menu/menu-login.html 템플릿을 반환
>>>>>>> ba6e39098d27fbb7cf38ef40ffcf775f0785289d
    }

    // 로그인 처리
    @PostMapping("/menu-login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
<<<<<<< HEAD
                        RedirectAttributes attributes) {

        // 실제 로그인 로직을 구현합니다. 여기서는 임시로 "admin" / "password"로 로그인 성공 처리하는 예시입니다.
        if ("admin".equals(username) && "password".equals(password)) {
            // 로그인 성공 시
=======
                        RedirectAttributes attributes,
                        Model model) {

        // 임시로 아무 값을 입력해도 로그인 성공으로 처리
        // 실제 개발에서는 이 부분을 데이터베이스 조회 등의 실제 로그인 로직으로 대체해야 합니다.
        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            // 로그인 성공 시
            model.addAttribute("loggedUser", username); // 세션에 사용자 이름 추가
>>>>>>> ba6e39098d27fbb7cf38ef40ffcf775f0785289d
            attributes.addFlashAttribute("loginSuccess", true); // 로그인 성공 여부를 Flash 속성으로 전달
            return "redirect:/index.html"; // 정적 리소스인 index.html 페이지로 리다이렉트
        } else {
            // 로그인 실패 시
            attributes.addFlashAttribute("loginError", true); // 로그인 실패 여부를 Flash 속성으로 전달
            return "redirect:/menu-login"; // 로그인 페이지로 리다이렉트 (오류 메시지 포함 가능)
        }
    }

<<<<<<< HEAD
    // 회원가입 페이지로 이동
    @GetMapping("/signup")
    public String signupPage() {
        return "signup"; // templates/signup.html 템플릿을 반환
=======
    // 로그아웃 처리
    @PostMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        // 세션에서 사용자 정보 삭제
        sessionStatus.setComplete();
        return "redirect:/index.html"; // 로그아웃 후 리다이렉트할 페이지
    }


    // 회원가입 페이지로 이동
    @GetMapping("/menu-signup")
    public String signupPage() {
        return "menu/menu-signup"; // templates/menu/menu-signup.html 템플릿을 반환
    }

    // 회원가입 처리
    @PostMapping("/menu-signup")
    public String signup(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         RedirectAttributes attributes) {

        // 실제 회원가입 로직을 구현합니다. 여기서는 간단히 성공 메시지를 Flash 속성으로 전달하는 예시입니다.
        // 여기에 실제 DB 등을 연결하여 회원가입 처리를 구현할 수 있습니다.

        // 가입 성공 시
        attributes.addFlashAttribute("signupSuccess", true);
        return "redirect:/menu-login"; // 로그인 페이지로 리다이렉트
>>>>>>> ba6e39098d27fbb7cf38ef40ffcf775f0785289d
    }
}
