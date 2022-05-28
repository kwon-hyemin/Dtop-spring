package crp.kr.api.user.domains;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;

/**
 * packageName: crp.kr.api.auth.domains
 * fileName : Role
 * author  : 권혜민
 * date   : 2022-05-23
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-23     권혜민       최초 생성
 */ // getter 만 사용 Readonly
@Getter
@RequiredArgsConstructor
public enum Role implements GrantedAuthority {
    ADMIN("ROLE_ADMIN","관리자권한"),
    USER("ROLE_USER","관리자권한"),
    UNKNOW_USER("ROLE_UNKNOWN","알 수 없는 사용자"),
    ;
    private final String code;
    private final String description;

    public static Role of(String code) {
        return Arrays.stream(Role.values()).filter(i -> i.getCode().equals(code))
                .findAny().orElse(UNKNOW_USER);
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
