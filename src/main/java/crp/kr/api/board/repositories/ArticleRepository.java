package crp.kr.api.board.repositories;

import crp.kr.api.board.domains.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


interface ArticleCustomRepository{
    // 000. title 과 content 를 수정하시오
    Article update(Article article);
}

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}