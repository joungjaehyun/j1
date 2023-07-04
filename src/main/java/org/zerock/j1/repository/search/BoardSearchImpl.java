package org.zerock.j1.repository.search;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.j1.domain.Board;
import org.zerock.j1.domain.QBoard;

import com.querydsl.jpa.JPQLQuery;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BoardSearchImpl extends QuerydslRepositorySupport implements BoardSearch {

    // 생성자를 만들어준다.
    public BoardSearchImpl() {
        super(Board.class);
    }

    // interface 메소드를 구현
    @Override
    public List<Board> search1() {

        // QueryDomain 이 필요하다
        QBoard board = QBoard.board;
        // Query를 동적으로 만들어내는 작업
        // SQL 문을 객체화 시켜놓은것
        JPQLQuery<Board> query = from(board);

        query.where(board.title.contains("1"));

        // list를 가져오는 방법
        List<Board> list = query.fetch();
        long count = query.fetchCount();

        log.info(list);
        log.info("count: " + count);

        return null;
    }

}
