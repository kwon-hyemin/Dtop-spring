package crp.kr.api.auth.domains;

import lombok.Builder;
import lombok.Getter;

/**
 * packageName: crp.kr.api.security.domains
 * fileName : Messenger
 * author  : 권혜민
 * date   : 2022-05-23
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-23     권혜민       최초 생성
 *///Been 객체가 아니다 @Component 를 사용하지 않앗기 떄문에

@Getter @Builder
public class Messenger {
    private String message, code;
    private int status;

}
