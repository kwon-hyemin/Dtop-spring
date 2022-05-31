package crp.kr.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Lazy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName: crp.kr.api.common.algorithm
 * fileName : PrimeNumber
 * author  : 권혜민
 * date   : 2022-05-17
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-17     권혜민       최초 생성
 */
public class PrimeNumber {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    private static class Solution{
        private int start, end;
        private int[] primes;

        @Override
        public String toString() {
            return String.format("시작: %d 끝: %d" );

        }
    }
    @FunctionalInterface interface SolutionService{ List<Integer> getSolution(PrimeNumber pn);}

    @Test
    void solutionTest(){
        List<Integer> l = Arrays.asList();
        SolutionService s = (pn) -> l.stream().collect(Collectors.toList());
    }

}
