package org.zerock.j1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.j1.domain.Board;
// repository생성
public interface BoardRepository  extends JpaRepository<Board,Long>{
    
}
