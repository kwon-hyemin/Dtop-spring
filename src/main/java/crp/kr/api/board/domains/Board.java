package crp.kr.api.board.domains;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Data
@Component
@Entity
@Table(name="article")
public class Board {
    @Id Long id;

    private String projects;
    private String startDate;
    private String status;
    private String team;
    private String progress;
    private String action;

}