package org.zerock.j1.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.j1.dto.PageResponseDTO;
import org.zerock.j1.dto.TodoDTO;
import org.zerock.j1.service.TodoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
//api 서버란뜻
@RequestMapping("/api/todos/")
@RequiredArgsConstructor
//CORS 해결 간단한방법1 annotation 좋은방법은 아니다.
@CrossOrigin
@Log4j2
public class TodoController {
    
    private final TodoService todoService;
    // todoList REST 방식
    @GetMapping("list")
    public PageResponseDTO<TodoDTO> list(){

        return todoService.getList();
    }
    // 등록하는 기능
    @PostMapping("")
    public TodoDTO register(@RequestBody TodoDTO todoDTO){
        log.info("register...................");
        log.info(todoDTO);
        
        return todoService.register(todoDTO);
    }
    // 1개의 게시글 조회하는 기능
    @GetMapping("/{tno}")
    public TodoDTO get(@PathVariable Long tno){
    //REST Controller -> advice처리해서 JSON 처리해주어야된다.

        return todoService.getOne(tno);
    }
}
