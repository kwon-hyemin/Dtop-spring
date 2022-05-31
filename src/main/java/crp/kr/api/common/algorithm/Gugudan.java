package crp.kr.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * packageName: crp.kr.api.common.algorithm
 * fileName : Gugudan
 * author  : 권혜민
 * date   : 2022-05-17
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-17     권혜민       최초 생성
 */
public class Gugudan {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    private static class Solution{
        private int [][] arr;
        @Override
        public String toString() {
            return String.format("구구단 출력 %d");
        }
    }

    @FunctionalInterface interface ISolution {void solution ();}

    @Test
    void test(){
        ISolution s = ()-> {
            for(int k = 2; k < 10; k+=4) {
                for (int i = 1; i < 10; i++) {
                    for (int j = k; j < k+4; j++) {
                        System.out.print(j + "*" + i+ "=" +(j*i)+"\t");
                    }
                    System.out.println();
                }
                System.out.println();
            }
        };
        s.solution();
    }

}
