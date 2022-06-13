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
    @ResponseBody
    public List<BoardEntity> getBoardList() {
        return boardRepository.findAll();
    }

    @GetMapping("/content/{boardId}")
    @ResponseBody
    public BoardEntity getBoard(@PathVariable("boardId") long boardId) {
        BoardEntity be = boardRepository.getById(boardId);
        be.setReadcnt(be.getReadcnt() + 1);
        boardRepository.save(be);
        return be;
    }

    @PostMapping("/content")
    @ResponseBody
    public BoardEntity createBoard(@RequestBody Board board) {
        System.out.println("title : "+board.getTitle());
        System.out.println("contents : "+board.getContents());
        System.out.println("board.getCreateuser() = " + board.getCreateuser());
        BoardEntity b = new BoardEntity();
        b.setTitle(board.getTitle());
        b.setContents(board.getContents());
        b.setCreateuser(board.getCreateuser());
        boardRepository.save(b);
        return b;
    }

}
