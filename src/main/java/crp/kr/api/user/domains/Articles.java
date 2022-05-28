package crp.kr.api.user.domains;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * packageName: crp.kr.api.auth.domains
 * fileName : Article
 * author  : 권혜민
 * date   : 2022-05-18
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-18     권혜민       최초 생성
 */
//자식
@Builder @Getter @AllArgsConstructor @NoArgsConstructor
//@Eager  // Eager <=> Lazy 의 반대말
@Entity
@Table (name = "articles")
public class Articles {
    @Id
    @Column(name = "article_id")
    @GeneratedValue
    private long articleId;

    @Column @NotNull private String title;
    @Column @NotNull private String content;
    @Column(name = "written_date") @NotNull private String writtenDate;

    @ManyToOne (fetch = FetchType.LAZY) // 1
    @JoinColumn(name = "user_id") //
    private User i; // 2

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Boards board;
}
