package com.example.mythymeleaf.controller;

import com.example.mythymeleaf.model.Board;
import com.example.mythymeleaf.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/list")
    public String list(Model model){
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id){
        if(id == null){
            model.addAttribute("board", new Board()); //form페이지로 Board객체를 전달 (비어있는 값)
        }
        else{
            Board board = boardRepository.findById(id).orElse(null); //id가 원래 있는경우 id값으로 db에서 꺼내와서
            model.addAttribute("board", board); //해당 id에 원래 있는내용을 보여줌
        }
        
        return "board/form";
    }

    @PostMapping("/form")
    public String submit(@Valid Board board, BindingResult bindingResult){ //form태그에서 board객체를 받아옴
        if (bindingResult.hasErrors()) {
            return "board/form";
        }

        boardRepository.save(board); //board에 id가 없을경우 insert, 있으면 update를 자동으로해줌
        return "redirect:/board/list"; //list로 redirect하면서 정보를 다시불러옴
    }
}
