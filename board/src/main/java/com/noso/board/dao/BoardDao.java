package com.noso.board.dao;


import com.noso.board.model.BoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardDao {
    // Mapper.xml 과 dao의 method가 같은 이름이어야 한다.
    public List<BoardDTO> selectAll();
}
