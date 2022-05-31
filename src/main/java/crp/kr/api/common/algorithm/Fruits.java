package crp.kr.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * packageName: crp.kr.api.common.algorithm
 * fileName : Frutes
 * author  : 권혜민
 * date   : 2022-05-17
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-17     권혜민       최초 생성
 */
// 36p
public class Fruits {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    private static class Solution{
        private int total, apple, grape, orange;

        @Override
        public String toString() {
            return String.format("total: %d, ");
        }
    };


    @FunctionalInterface interface ISolution { Solution solution(Solution s);}
    @Test
    void solutionTest(){}
    }

