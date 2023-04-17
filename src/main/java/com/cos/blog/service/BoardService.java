package com.cos.blog.service;

import com.cos.blog.config.auth.PrincipalDetail;
import com.cos.blog.model.Board;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;
    @Transactional
    public void write(Board board, User user) { //title, content
        board.setUser(user);
        System.out.println(board);
        boardRepository.save(board);
    }
    @Transactional(readOnly = true)
    public Page<Board> posts(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }
    @Transactional(readOnly = true)
    public Board boardDetail(int id) {
        return boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("글 상세보기 실패"));
    }
    @Transactional
    public void deleteBoard(int id, PrincipalDetail principal) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("글 찾기 실패"));

        if (board.getUser().getId() != principal.getUser().getId()) {
            throw new IllegalStateException("해당 글을 삭제 할 권한이 없습니다");
        }
        boardRepository.deleteById(id);
    }

    @Transactional
    public void update(int id, Board requestBoard) {
        Board findBoard = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("글 찾기 실패"));
        findBoard.setTitle(requestBoard.getTitle());
        findBoard.setContent(requestBoard.getContent());

        //트랜잭션 종료 시 더티체킹으로 자동 업데이트
    }

}
