package org.zerock.j1.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.j1.domain.Board;
import org.zerock.j1.domain.Reply;
import org.zerock.j1.repository.ReplyRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void insertOne() {

        Long bno = 100L;

        Board board = Board.builder().bno(bno).build();

        Reply reply = Reply.builder()
                .replyText("Reply......1")
                .replyer("replyer00")
                .board(board)
                .build();

        replyRepository.save(reply);
    }

    @Test
    public void testInsertDummies() {

        Long[] bnoArr = { 99L, 96L, 92L, 84L, 81L };

        for (Long bno : bnoArr) {

            Board board = Board.builder().bno(bno).build();

            for (int i = 0; i < 5; i++) {

                Reply reply = Reply.builder()
                        .replyText("Reply..." + bno + "--" + i)
                        .replyer("replyer" + i)
                        .board(board)
                        .build();

                replyRepository.save(reply);
            }
        }
    }
}
