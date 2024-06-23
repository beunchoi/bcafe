package com.bcafe.domain.board.service;

import com.bcafe.domain.board.dto.BoardRequestDto;
import com.bcafe.domain.board.dto.BoardResponseDto;
import com.bcafe.domain.board.entity.Board;
import com.bcafe.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;

  public BoardResponseDto createBoard(BoardRequestDto boardRequestDto) {
    Board board = new Board(boardRequestDto.getBoardNm());

    Board savedBoard = boardRepository.save(board);

    return new BoardResponseDto(savedBoard.getBoardNm());
  }
}
