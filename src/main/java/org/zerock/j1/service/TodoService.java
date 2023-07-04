package org.zerock.j1.service;

import org.springframework.transaction.annotation.Transactional;

import org.zerock.j1.dto.PageResponseDTO;
import org.zerock.j1.dto.TodoDTO;

@Transactional
public interface TodoService {
    //Read
    PageResponseDTO<TodoDTO> getList();
    // Create
    TodoDTO register(TodoDTO dto);
    //Read
    TodoDTO getOne(Long tno);
}
