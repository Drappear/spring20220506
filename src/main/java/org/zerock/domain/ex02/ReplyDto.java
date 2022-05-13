package org.zerock.domain.ex02;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReplyDto {
	private int id;
	private int boardId;	// board_id 컬럼과 매칭되기때문에 별칭 설정에 유의
	private String content;
	private LocalDateTime inserted;
}
