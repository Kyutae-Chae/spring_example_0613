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
//        return boardRepository.findAll();
        List<BoardEntity> list = boardRepository.findAll();
        for (BoardEntity boardEntity : list) {
            System.out.println("boardEntity.getContents() = " + boardEntity.getContents());
            System.out.println("boardEntity.getTitle() = " + boardEntity.getTitle());
        }
        return list;
    }

    @GetMapping("/content/{boardId}")
    @ResponseBody
    public BoardEntity getBoard(@PathVariable("boardId") long boardId) {
        BoardEntity be = boardRepository.getById(boardId);
//        be.setReadcnt(be.getReadcnt() + 1);
//        boardRepository.save(be);
        return be;
    }

//    @PostMapping("/content")
//    @ResponseBody
//    public BoardEntity createBoard(Board board) {
////        System.out.println("title : "+board.getTitle());
////        System.out.println("contents : "+board.getContents());
//        BoardEntity b = new BoardEntity();
//        b.setTitle(board.getTitle());
//        b.setContents(board.getContents());
//        b.setCreate_user(board.getCreate_user());
//        boardRepository.save(b);
//        return b;
//    }

}
