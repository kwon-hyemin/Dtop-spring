package crp.kr.api.common.streams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class HelloStream {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    public static class Solution{
        private String greeting, inLanguage;
        @Override
        public String toString() {
            return String.format("인사 : %s %s", inLanguage, greeting);
        }
    }
    private interface SolutionService{Solution solution(Solution s);}
    @Test
    void testSolution(){
        String greeting = "안녕";
        String inLanguage = "한국어";
        SolutionService f = e -> {
            List<Solution> l = List.of();
          return Solution.builder().greeting(greeting).inLanguage(inLanguage).build();
        };
        Solution s = Solution.builder().build();
        System.out.println(f.solution(s));

    }
}
