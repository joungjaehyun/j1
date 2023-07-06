package org.zerock.j1.dto;

import java.util.List;

import lombok.Data;

// JSON으로 만들때, 어떤것들을 전달할 것인가
// 어떻게 만들 것인가.
// 통신할때 최대한 단순하게 해준다.

@Data

public class PageResponseDTO<E> {
    
    private List<E> dtoList;
    
    private long totalCount;

    private List<Integer> pageNums;

    private boolean prev, next;
    
    private PageRequestDTO requestDTO;
    
    public PageResponseDTO(List<E> dtoList, long totalCount, PageRequestDTO pageRequestDTO){
       
        this.dtoList = dtoList;
        this.totalCount = totalCount;
        this.requestDTO = pageRequestDTO;
    }
}
