package crp.kr.api.user.domains;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName: crp.kr.api.auth.domains
 * fileName : Board
 * author  : 권혜민
 * date   : 2022-05-18
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-18     권혜민       최초 생성
 */
//부모
@Builder @Getter @AllArgsConstructor @NoArgsConstructor
//@Eager
@Entity
@Table (name = "boards")
public class Boards {
    @Id
    @Column(name = "board_id")
    @GeneratedValue
    private long boardId;
    @Column private @NotNull
    String boardName;
    @Column(name = "created_date") @NotNull private String createdDate;

    @OneToMany(mappedBy = "board")
    List<Articles> l1 = new ArrayList<>();


}
