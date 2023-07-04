package org.zerock.j1.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.j1.domain.Board;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {
    
    // 테스트를 위한 DI
    @Autowired
    private BoardRepository boardRepository;

    // insert 테스트
    @Test
    public void testInsert(){
        Board board = Board.builder()
        .title("Sample Title")
        .content("Sample Content")
        .writer("user00")
        .build();
        boardRepository.save(board);
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

}
