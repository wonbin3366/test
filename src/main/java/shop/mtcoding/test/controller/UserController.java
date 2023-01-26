package shop.mtcoding.test.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.test.model.BoardRepository;
import shop.mtcoding.test.model.User;
import shop.mtcoding.test.model.UserRepository;

@Controller
public class UserController {

    @Autowired
    private HttpSession session;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping({ "/", "/loginForm" })
    public String loginForm() {
        return "user/loginForm";
    }

    @PostMapping("/login")
    public String login(String username, String password, String remember, HttpServletResponse response) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        System.out.println("userid : " + user.getId());
        if (user == null) {
            return "redirect:/loginForm";
        } else {
            // 요청헤더 : Cookie
            // 응답헤더 : Set-Cookie
            if (remember == null) {
                remember = "";
            }

            if (remember.equals("on")) {
                // Set- Cookie
                Cookie cookie = new Cookie("remember", username);
                response.addCookie(cookie);
            } else {
                Cookie cookie = new Cookie("remember", "");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
            response.addHeader("hello", remember);
            session.setAttribute("principal", user);
            return "redirect:/list";
        }

    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @PostMapping("/join")
    public String join(String username, String password, String email) {
        int result = userRepository.insert(username, password, email);
        if (result == 1) {
            return "redirect:/loginForm";
        } else {
            return "redirect:/joinForm";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/info")
    public String info() {
        User user = (User) session.getAttribute("principal");
        if (user == null) {
            return "redirect:/error";
        }
        return "/user/info";
    }

    @PostMapping("/update")
    public String update(String password, String email) {
        User user = (User) session.getAttribute("principal");
        int result = userRepository.updateByPasswordEmail(password, email, user.getId());
        if (result != 1) {
            return "redirect:/error";
        }
        return "redirect:/list";
    }
}
