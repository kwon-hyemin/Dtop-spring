package crp.kr.api.user.domains;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName: crp.kr.api.domains
 * fileName : User
 * author  : 권혜민
 * date   : 2022-05-03
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-03     권혜민       최초 생성
 */
//부모
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor  // data 지우고 4개 추가
//컴포넌트는 프로퍼티와 메소드의 집합이다.
@Entity
@Setter
//@Eager
@Table(name="users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue private long userId;
    @Column private @NotNull String username;
    @Column private @NotNull String password;
    @Column private @NotNull String name;
    @Column private @NotNull String email;
    @Column(name = "reg_date") @NotNull private String regDate;

    @OneToMany(mappedBy = "i") //3
    List<Articles> l = new ArrayList<>();//4
    @ElementCollection(fetch = FetchType.EAGER)
    public List<Role> roles;

}
