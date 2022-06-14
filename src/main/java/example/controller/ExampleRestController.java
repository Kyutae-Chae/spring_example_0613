package example.controller;

import example.Board;
import example.BoardEntity;
import example.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExampleRestController {

    @Autowired
    BoardRepository boardRepository;

    @GetMapping("/contents")
    public List<BoardEntity> getBoardList() {
        return boardRepository.findAll();
    }

    @GetMapping("/content/{boardId}")
    public BoardEntity getBoard(@PathVariable("boardId") long boardId) {
        BoardEntity be = boardRepository.getById(boardId);
        be.setReadcnt(be.getReadcnt() + 1);
        boardRepository.save(be);
        return be;
    }

    @PostMapping("/content")
    public BoardEntity createBoard(@RequestBody Board board) {
        BoardEntity b = new BoardEntity();
        b.setTitle(board.getTitle());
        b.setContents(board.getContents());
        b.setCreateuser(board.getCreateuser());
        boardRepository.save(b);
        return b;
    }

    @PatchMapping("/content/{boardId}")
    public BoardEntity updateBoard(@RequestBody Board board, @PathVariable("boardId") long boardId) {
        System.out.println("board.getTitle() = " + board.getTitle());
        System.out.println("board.getContents() = " + board.getContents());
        BoardEntity b = new BoardEntity();
        b.setIdBoard(boardId);
        b.setTitle(board.getTitle());
        b.setContents(board.getContents());
        b.setCreateuser(board.getCreateuser());
        boardRepository.save(b);
        return b;
    }

    @DeleteMapping("/content/{boardId}")
    public boolean deleteBoard(@PathVariable("boardId") long boardId) {
        if (boardRepository.findById(boardId).isPresent()) {
            boardRepository.deleteById(boardId);
            return true;
        }
        return false;
    }

}
