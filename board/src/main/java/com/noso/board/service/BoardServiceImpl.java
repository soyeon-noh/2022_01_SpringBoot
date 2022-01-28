package com.noso.board.service;

import com.noso.board.dao.BoardDao;
import com.noso.board.model.BoardDTO;
import org.springframework.stereotype.Service;

import java.util.List;

// service impl 에... service annotation 붙이기..
@Service
public class BoardServiceImpl implements BoardService {

    private BoardDao boardDao;

    public BoardServiceImpl(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Override
    public BoardDTO findById(Long seq) {
        return null;
    }

    @Override
    public List<BoardDTO> selectAll() {
        return boardDao.selectAll();
    }

    @Override
    public int delete(Long seq) {
        return 0;
    }

    @Override
    public int update(BoardDTO dto) {
        return 0;
    }

    @Override
    public int insert(BoardDTO dto) {
        int result = boardDao.insert(dto);
        System.out.println(result);
        return result;
    }
}
