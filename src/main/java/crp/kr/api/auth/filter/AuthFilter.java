package crp.kr.api.auth.filter;

import crp.kr.api.auth.configs.AuthProvider;
import crp.kr.api.auth.domains.Auth;
import crp.kr.api.auth.exception.SecurityRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * packageName: crp.kr.api.auth.fiter
 * fileName : AuthFiter
 * author  : 권혜민
 * date   : 2022-05-25
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-25     권혜민       최초 생성
 */
@RequiredArgsConstructor //필터는 세균이다 라고 판단해주면 백혈구가 가서 제거해준다
public class AuthFilter extends OncePerRequestFilter {
    private final AuthProvider provider;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        provider.resolveToken(request); // 리퀘스트 안에 잇는 토큰에 대해 처리를 한다.
            String token = provider.resolveToken(request); //체크는 프로바이더가 판단하는것 필터가 판단하는것이 아니다
            try {
                if(token != null && provider.validateToken(token)){
                    Authentication auth = provider.getAuthentication(token);
                    SecurityContextHolder.clearContext();// 컨테스트라는곳은 Been 객체들이 모인곳
                    SecurityContextHolder.getContext().setAuthentication(auth); // 허가 받으면 들어올수 있게됨
                }// 프로바이더에게 내가 뽑아놓은 토큰이 유효한지, 있는지 없는지 검사하는 코드 //필터는 경비원
            }//꺼내서 유효성 체크
            catch (SecurityRuntimeException ex) {
                //this is very important, since it guarantees the user is not authenticated at all
                SecurityContextHolder.clearContext();
                response.sendError(ex.getHttpStatus().value(), ex.getMessage());
                return;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }   //회사에서 줄수있는 부분 제공하는 코드 (스위치)
        filterChain.doFilter(request, response);
    }
}
