package org.zerock.j1.service;

import org.zerock.j1.dto.PageResponseDTO;
import org.zerock.j1.dto.ReplyDTO;
import org.zerock.j1.dto.ReplyPageRequestDTO;

import jakarta.transaction.Transactional;

@Transactional
public interface ReplyService {
    
    // reply list
    PageResponseDTO<ReplyDTO> list(ReplyPageRequestDTO requestDTO);

    // reply insert
    Long register(ReplyDTO replyDTO);


}
