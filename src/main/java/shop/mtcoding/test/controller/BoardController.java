package shop.mtcoding.test.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.test.model.Board;
import shop.mtcoding.test.model.BoardRepository;
import shop.mtcoding.test.model.User;
import shop.mtcoding.test.model.UserRepository;

@Controller
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession session;

    @GetMapping("/list")
    public String list(Model model) {
        User user = (User) session.getAttribute("principal");
        List<Board> boardList = boardRepository.findById(user.getId());
        model.addAttribute("boardList", boardList);
        return "/board/list";
    }

}
