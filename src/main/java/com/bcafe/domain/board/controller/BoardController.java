package com.bcafe.domain.board.controller;

import com.bcafe.domain.board.dto.BoardRequestDto;
import com.bcafe.domain.board.dto.BoardResponseDto;
import com.bcafe.domain.board.service.BoardService;
import com.bcafe.global.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
  private final BoardService boardService;

  @PostMapping
  public ResponseEntity<CommonResponse<BoardResponseDto>> createBoard(@RequestBody BoardRequestDto boardRequestDto) {
    return CommonResponse.ok(boardService.createBoard(boardRequestDto));
  }

  @PutMapping
  public ResponseEntity<CommonResponse<BoardResponseDto>> updateBoard(@RequestParam Long boardId, @RequestBody BoardRequestDto boardRequestDto) {
    return CommonResponse.ok(boardService.updateBoard(boardId, boardRequestDto));
  }
}
