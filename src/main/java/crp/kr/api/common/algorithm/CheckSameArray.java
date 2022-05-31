package crp.kr.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * packageName: crp.kr.api.common.algorithm
 * fileName : CheckSameArray
 * author  : 권혜민
 * date   : 2022-05-17
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-17     권혜민       최초 생성
 */
//02-3 순서가없는 두배열에서 같은 요소를 포함하는지 판별하는 메서드를 작성
public class CheckSameArray {
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Solution{
        private String result;
        @Override
        public String toString() {
            return String.format("A 과 B 은 %s 배열입니다.", result);
        }
    }

    @FunctionalInterface interface ISolution {Solution solution (Solution s);}

    @Test
    void solutionTest(){
        int[] arr1 = {1, 3, 2};
        int[] arr2 = {2, 3, 1};
    }

}
