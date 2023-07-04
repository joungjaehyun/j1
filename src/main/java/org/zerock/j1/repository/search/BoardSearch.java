package org.zerock.j1.repository.search;

import java.util.List;

import org.zerock.j1.domain.Board;

// 검색기능을위한 interface 
// 이름 일치시켜야된다. BoardSearch --> BoardSearchImpl
public interface BoardSearch {
    
    
    // List를 뽑는 메소드
    
    List<Board> search1();
}
