package com.noso.board.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noso.board.model.BoardDTO;
import com.noso.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    // requiredArgsConstructor 아래와같이 생성자 안만들었을 때 필요
    protected final BoardService bService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = {"", "/"})
    public String main() {

        List<BoardDTO> bList = bService.selectAll();

        ObjectMapper objMapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = objMapper.writeValueAsString(bList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("Json 오류");
        }
        return jsonString;
    }


    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = {"", "/"})
    public String write(@RequestBody BoardDTO boardDTO) {

        if (boardDTO != null) {
            int result = bService.insert(boardDTO);
            if (result != 1) {
                return "FAIL: SQL 오류";
            }
            return "OK";
        }
        return "FAIL: client 값이 전달되지 않음";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value ={"/board"})
    public String delete(@RequestBody List<Long> seqList){

        System.out.println("seqList" + seqList);
        if(seqList != null){
            int result = bService.delete(seqList);
            if( result != 1){
                return "FAIL: SQL 오류";
            }
            return "OK";
        }
        return "FAIL: client 값이 전달되지 않음";


    }
}
