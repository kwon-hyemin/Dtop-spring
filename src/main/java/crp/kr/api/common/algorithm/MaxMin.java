package crp.kr.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName: crp.kr.api.common.algorithm
 * fileName : MaxMin
 * author  : 권혜민
 * date   : 2022-05-17
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-17     권혜민       최초 생성
 */
public class MaxMin {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Solution{
        private int[] arr = {3, 1, 9, 5, 10};
        private int elem;
        @Override
        public String toString() {
            int min = 0;
            int max = 0;
            return String.format("최소값 %d 최대값 %d", min , max);
        }
    }
    interface SolutionService{
        public int getMin(int[] arr);
        public int getMax(int[] arr);
    }
    public static class MinServiceImpl implements SolutionService{
        @Override
        public int getMin(int[] arr) {
            int min = 0;
            return min;
        }
        @Override
        public int getMax(int[] arr) {
            int max = 0;
            return max;
        }
    }
    @Test
    void MaxMinTest(){};
}
