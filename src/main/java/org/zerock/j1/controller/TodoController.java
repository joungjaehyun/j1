package org.zerock.j1.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.j1.dto.PageResponseDTO;
import org.zerock.j1.dto.TodoDTO;
import org.zerock.j1.service.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
//api 서버란뜻
@RequestMapping("/api/todos/")
@RequiredArgsConstructor
//CORS 해결 간단한방법1 annotation 좋은방법은 아니다.
@CrossOrigin
public class TodoController {
    
    private final TodoService todoService;
    // todoList REST 방식
    @GetMapping("list")
    public PageResponseDTO<TodoDTO> list(){

        return todoService.getList();
    }
}
