package crp.kr.api.auth.filter;

import crp.kr.api.auth.domains.Messenger;
import crp.kr.api.auth.exception.ErrorCode;
import crp.kr.api.auth.exception.LoginRunnerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

/**
 * packageName: crp.kr.api.auth.filter
 * fileName : AuthException
 * author  : 권혜민
 * date   : 2022-05-25
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-25     권혜민       최초 생성
 */
@Slf4j // 롬복꺼  controller 가 들어가기전에 시키는것  //핸들러는 컨트롤러 앞에 대기하고 잇음
@ControllerAdvice  // advice 는 어느 타이밍 // 컨트롤러를 들어가기 직전에 이것을 해라 // 프로바이더는 여권만 발급만한다 // 필터는 확인하는 일을함 토큰을 다알고잇다 암구호도 이미 알고잇음

public class AuthExceptionHandler {
    @ExceptionHandler(RuntimeException.class)//런타임 익셉션이 발생했을때
    protected ResponseEntity<Messenger> handleRuntimeExeption(RuntimeException e){
        log.info("handleRuntimeException", e);
        return new ResponseEntity<>( Messenger.builder().code("test")
                .message(e.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }  //잘못됏다고 메신저를 보냄
    @ExceptionHandler(SecurityException.class)
    protected ResponseEntity<Messenger> handleSecurityException(SecurityException e){
        log.info("handleSecurityException",e);
        return new ResponseEntity<>(Messenger.builder().code(ErrorCode.AUTHENTICATION_FAILED.getCode())
                .message(e.getMessage())
                .status(ErrorCode.AUTHENTICATION_FAILED.getStatus())
                .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(LoginRunnerException.class)
    protected ResponseEntity<Messenger> handleLoginRunnerException(LoginRunnerException e){
        log.info("handleLoginRunnerException",e);
        return new ResponseEntity<>(Messenger.builder().code(ErrorCode.LOGIN_FAILED.getCode())
                .message(ErrorCode.LOGIN_FAILED.getMsg())
                .status(ErrorCode.LOGIN_FAILED.getStatus())
                .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BadCredentialsException.class)
    protected ResponseEntity<Messenger> handleBadCredentialsException(BadCredentialsException e){
        log.info("handleBadCredentialsException",e);
        return new ResponseEntity<>(Messenger.builder().code(ErrorCode.ACCESS_DENIED.getCode())
                .message(ErrorCode.ACCESS_DENIED.getMsg())
                .status(ErrorCode.ACCESS_DENIED.getStatus())
                .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<Messenger> handleAccessDeniedException(AccessDeniedException e){
        log.info("handleAccessDeniedException",e);
        return new ResponseEntity<>(Messenger.builder().code(ErrorCode.ACCESS_DENIED.getCode())
                .message(ErrorCode.ACCESS_DENIED.getMsg())
                .status(ErrorCode.ACCESS_DENIED.getStatus())
                .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    protected ResponseEntity<Messenger> handleInsufficientAuthenticationException(InsufficientAuthenticationException e){
        log.info("handleAInsufficientAuthenticationException",e);
        return new ResponseEntity<>(Messenger.builder().code(ErrorCode.AUTHENTICATION_FAILED.getCode())
                .message(ErrorCode.AUTHENTICATION_FAILED.getMsg())
                .status(ErrorCode.AUTHENTICATION_FAILED.getStatus())
                .build(), HttpStatus.UNAUTHORIZED);
    }
}
