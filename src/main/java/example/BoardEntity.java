package example;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idboard", nullable = false)
    private Long idBoard;
    private String title;
    private String contents;
    @Column(name = "readcnt")
    private int readcnt;
    @Column(name = "createuser")
    private String createuser;

//    public Long getIdBoard() {
//        return idBoard;
//    }
//
//    public int getRead_cnt() {
//        return readcnt;
//    }
//
//    public String getCreate_user() {
//        return createuser;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getContents() {
//        return contents;
//    }

}
