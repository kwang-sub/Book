package org.zerock.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.dto.BoardDTO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceImplTest {

    @Autowired
    private BoardService service;

    @Test
    public void testRegister() {
        BoardDTO dto = BoardDTO.builder()
                .title("Test")
                .content("test")
                .writerEmail("user1@aaa.com")
                .build();
        Long bno = service.register(dto);
        System.out.println(bno);
    }
}