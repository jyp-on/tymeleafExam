package com.example.mythymeleaf.service;

import com.example.mythymeleaf.model.Board;
import com.example.mythymeleaf.model.User;
import com.example.mythymeleaf.repository.BoardRepository;
import com.example.mythymeleaf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public Board save(String username, Board board){
    User user = userRepository.findByUsername(username);
    board.setUser(user);
    return boardRepository.save(board);


    }

}
