package org.zerock.j1.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.j1.domain.Todo;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {
    
    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void testInsert(){

        IntStream.rangeClosed(1, 100).forEach(i->{

            Todo todo = Todo.builder().title("Title" +i).build();
            // myBatis에서 select key 하는것을 안해도 된다. 
            // JPA가 다 따와서 가져온다.
            // ID가 없으므로 select를 안날리고 insert로 일어난다.
            Todo result = todoRepository.save(todo);

            log.info(result);
        });
        
    }
    
    @Test
    public void testPaging(){
        // Entity 멤버변수 명으로
        Pageable pageable
         = PageRequest.of(0,10,Sort.by("tno").descending());

        Page<Todo> result= todoRepository.findAll(pageable);

        log.info(result);
    }

}
