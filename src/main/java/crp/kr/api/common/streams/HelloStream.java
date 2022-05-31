package crp.kr.api.common.streams;

import lombok.*;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * packageName: crp.kr.api.common.streams
 * fileName : HelloStream
 * author  : 권혜민
 * date   : 2022-05-16
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-16     권혜민       최초 생성
 */
// 한국어로 안녕, 영어로 Hello,
public class HelloStream {
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Hello{
        private String greeting,inLanguage;

        @Override public String toString() {
            return String.format("인사 : %s %s", inLanguage, greeting);
        }
    }
    interface HelloService{
        Set<Hello> greet(List<Hello> arr);

        }
    static class HelloServiceImpl implements HelloService{
        @Override
        public Set<Hello> greet(List<Hello> arr){
            return arr
                    .stream()
                    .filter(e -> e.getInLanguage().equals("영어"))
                    .collect(Collectors.toSet());
        }
    }
    @Test
    void helloTest(){
        List<Hello> arr = Arrays.asList(
                Hello.builder().inLanguage("영어").greeting("Hello").build(),
                Hello.builder().inLanguage("한국어").greeting("안녕").build()
        );
        new HelloServiceImpl()
                .greet(arr)
                .forEach(System.out::print);
    }

}
