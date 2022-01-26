package com.noso.board.service;

import com.noso.board.model.BoardDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BoardService {

    public BoardDTO findById(Long seq);
    public List<BoardDTO> selectAll();
    public int delete(Long seq);
    public int update(BoardDTO dto);
    public int insert(BoardDTO dto);
}
