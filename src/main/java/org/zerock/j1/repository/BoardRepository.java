package org.zerock.j1.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.j1.domain.Board;
// repository생성
public interface BoardRepository  extends JpaRepository<Board,Long>{
    // repository에 메소드명을 넣으면
    // 자동으로 쿼리 메소드를 만들어낸다.
    // 생각보다 사용되진 않는다 why? 복잡한 쿼리 문을 생성을 하기 힘들기떄문.
    // 실제로 사용되는것은 JPQL을 사용한다.
    List<Board> findByTitleContaining(String title);

    // JPQL 방식 @Query annotation을 넣어준다 
    // * 사용 불가 alias사용하거나 entity property사용
    // 변수앞에는 항상 @Param(명칭)
    // DDL은 @Modify라는 annotation을 붙여줘야된다. => 웬만해선 사용하는 것을지양해야된다.
    // 장점 join 처리시 결과뽑아내는게 좋다.
    @Query("select b from Board b where b.title like %:title% ")
    List<Board> listTitle(@Param("title")String title);

    // Paging 까지 된 쿼리메소드
    // 마지막 매개변수로 Pageable이 들어가면 Page타입으로 리턴해야되고
    // Paging 을 처리해 준다.
    // order by 까지 지원해준다.
    Page<Board> findByContentContaining(String content,org.springframework.data.domain.Pageable pageable);



}
