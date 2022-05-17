package crp.kr.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * packageName: crp.kr.api.common.algorithm
 * fileName : MinMax2
 * author  : 권혜민
 * date   : 2022-05-17
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-17     권혜민       최초 생성
 */
public class MinMax2 {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    private static class Solution{
        private int[] arr;
        private int max, min;

        @Override
        public String toString() {

            return String.format("최소값: %d 최대값: %d ", min, max);
        }
    }
    @FunctionalInterface private interface SolutionService { Solution solution(Solution s);}//2. s 파라미터 실행
    @Test
    void testSolution() {
        int[] arr = {3, 1, 9, 5, 10};
        SolutionService f = e->{   //3. e element 실행
            int max = 0;
            int min = 10;
            for (int i: e.getArr()){
                if(i > max)max = 10;
                else if (i< min)min = 1;}
            return Solution.builder().max(max).min(min).build();};// 4.Solution 객체를 Builder 객체로 만들어서 담음
        Solution s = Solution.builder().arr(arr).build();  //5. s 에 arr 빌더객체 담음 Solution 을 실행시켜서 min max값 출력
        System.out.println(f.solution(s));//1. f.solution(s) 실행
    }
}
//        Function<List<Integer>, Integer> f = e -> {
//            List<Integer> l = Arrays.asList(3, 1, 9, 5, 10);
//            List<Integer> l2 = new ArrayList<>(); // arraylist 하나 만듬
//            int min = 10;
//            for (int i : l) {
//                if (i < min) min = i;
//            }
//            return min;