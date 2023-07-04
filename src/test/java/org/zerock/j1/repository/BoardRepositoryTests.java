package org.zerock.j1.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.j1.domain.Board;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {
    
    // 테스트를 위한 DI
    @Autowired
    private BoardRepository boardRepository;

    // Insert 테스트
    @Test
    public void testInsert(){
        for(int i=0; i<100; i++){
        Board board = Board.builder()
        .title("Sample Title" +i)
        .content("Sample Content" +i)
        .writer("user" + (i%10))
        .build();
        
        
        boardRepository.save(board);
        }
    }

    // Read 테스트
    @Test
    public void testRead(){

        Long bno = 1L;

        Optional<Board> result = boardRepository.findById(bno);

        log.info("--------------------------------");

        Board board = result.orElseThrow();

        log.info(board);
    }
    // Update 테스트
    @Test
    public void testUpdate(){
        // JPA 업데이트는 Mybatis 방식과 다르다.
        // 조회후 save를 다시하는 방법
        // 이방식이 복잡하고 너무길다 싶을때 쓰는게
        // Query method 방식
        Long bno = 1L;

        Optional<Board> result = boardRepository.findById(bno);

        Board board = result.orElseThrow();
        board.changeTitle("Update Title");

        boardRepository.save(board);
    }
    @Test
    public void testQuery1(){

        java.util.List<Board> list = boardRepository.findByTitleContaining("1");

        log.info("----------------------");
        log.info(list.size());
        log.info(list);
    }
    // 검색하면서 Paging 처리가 되는방법
    @Test
    public void testQuery2(){

        Pageable pageable = PageRequest.of(
            0,10,Sort.by("bno").descending());
        
        Page<Board> result = boardRepository.findByContentContaining("1", pageable);

        log.info("------------------------");
        log.info(result);
    }
}
