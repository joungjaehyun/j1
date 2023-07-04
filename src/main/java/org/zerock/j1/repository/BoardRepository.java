package org.zerock.j1.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.j1.domain.Board;
// repository생성
public interface BoardRepository  extends JpaRepository<Board,Long>{
    // repository에 메소드명을 넣으면
    // 자동으로 쿼리 메소드를 만들어낸다.
    // 생각보다 사용되진 않는다 why? 복잡한 쿼리 문을 생성을 하기 힘들기떄문.
    // 실제로 사용되는것은 JPQL을 사용한다.
    List<Board> findByTitleContaining(String title);

    // Paging 까지 된 쿼리메소드
    // Pageable이 들어가면 Page 타입으로 리턴 
    // order by 까지 지원해준다.
    Page<Board> findByContentContaining(String content,org.springframework.data.domain.Pageable pageable);
}
