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
        return boardDao.selectOne(seq);
    }

    @Override
    public List<BoardDTO> selectAll() {
        return boardDao.selectAll();
    }



    @Override
    public int delete(List<Long> seqList) {

        for(Long seq: seqList){
            boardDao.delete(seq);
        }
        return 1;
    }

    @Override
    public int update(BoardDTO dto) {
        int result = boardDao.update(dto);
        System.out.println(result);
        return result;
    }

    @Override
    public int insert(BoardDTO dto) {
        int result = boardDao.insert(dto);
        System.out.println(result);
        return result;
    }
}
