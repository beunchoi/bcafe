package com.bcafe.domain.board.service;

import com.bcafe.domain.board.dto.BoardRequestDto;
import com.bcafe.domain.board.dto.BoardResponseDto;
import com.bcafe.domain.board.entity.Board;
import com.bcafe.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;

  @Transactional
  public BoardResponseDto createBoard(BoardRequestDto boardRequestDto) {

    Board savedBoard = boardRepository.save(new Board(boardRequestDto.getBoardNm()));

    return new BoardResponseDto(savedBoard.getBoardNm());
  }

  @Transactional
  public BoardResponseDto updateBoard(Long boardId, BoardRequestDto boardRequestDto) {

    Board board = findBoard(boardId);

    board.updateBoard(boardRequestDto.getBoardNm());

    return new BoardResponseDto(board.getBoardNm());
  }

  @Transactional
  public BoardResponseDto deleteBoard(Long boardId) {

    Board board = findBoard(boardId);

    boardRepository.delete(board);

    return new BoardResponseDto(board.getBoardNm());
  }

  private Board findBoard(Long boardId) {

    return boardRepository.findById(boardId)
        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시판입니다."));
  }
}
