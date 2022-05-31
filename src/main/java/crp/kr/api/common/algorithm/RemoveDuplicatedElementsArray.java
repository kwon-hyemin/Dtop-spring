package crp.kr.api.common.algorithm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * packageName: crp.kr.api.common.algorithm
 * fileName : RemoveDuplicaetedElementsArray
 * author  : 권혜민
 * date   : 2022-05-17
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-17     권혜민       최초 생성
 */
// 02-4 중복된 요소를 제거한 새배열을 반환하는 메서드를 작성해보라
// 중복 제거된 빈요소는 기본값 0으로 삽입
public class RemoveDuplicatedElementsArray {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    private static class Solution{
        private int arr;// 원래잇는
        @Override
        public String toString() {
            return String.format("새배열: %d", arr);
        }
    }
    //배열를 Set 타입으로 변환
    @FunctionalInterface private interface SolutionService{ Solution solution(Solution s);}
    @Test
    void solutionTest(){
//        int[] resultArr = Arrays.stream(arr).distinct().toArray(int[]::new);
//        arr = Arrays.stream(arr).distinct().toArray(String[]::new);
//        SolutionService f = e ->  {
//            String[] ls = Arrays.stream(arr).distinct().toArray(String[]::new);// ls에 값 잘담김
//            return Solution.builder().ls(ls).build();};  // ls 값 중복빼고 잘들어옴
//        Solution s = Solution.builder().arr(arr).build();// arr == string[]arr 값이랑 같음
//        System.out.println(f.solution(s));
//        String[] arr = {"5", "10", "9", "27", "2"," 8", "10", "4", "27", "1"};
//        SolutionService f = e-> {
//            HashSet<String> hashSet = new HashSet<>(Arrays.asList(arr));// 배열을 HashSet 으로 변환
//            String[] ls = hashSet.toArray(new String[0]); // HashSet 을 배열로 변환
//            return Solution.builder().arr(Arrays.toString(ls)).build();}; // Solution 객체를 String 배열 ls 로 리턴
//        Solution s = Solution.builder().build();//
//        System.out.println(f.solution(s));
//        String[] arr = {"5", "10", "9", "27", "2"," 8", "10", "4", "27", "1"};
//        SolutionService f = e -> {
//            String[] ls = (String[]) Arrays.stream(arr).distinct().toArray();
//          return Solution.builder().arr(Arrays.toString(ls)).build();
//        };
//        Solution s = Solution.builder().build();
//        System.out.println(f.solution(s));
//        Integer[] arr = {5, 10, 9, 27, 2, 8, 10, 4, 27, 1};
//        SolutionService f = e ->{
//            Set<Integer> set = new HashSet<Integer>(Arrays.asList(arr));// 배열을 객체로 변환
//            Integer[] ls = set.toArray(new Integer[0]);
//            return Solution.builder().arr(Integer.parseInt(Arrays.toString(ls))).build();};
//        Solution s = Solution.builder().build();
//        System.out.println(f.solution(s));
        int[] arr = {5, 10, 9, 27, 2, 8, 10, 4, 27, 1};
        SolutionService f = e ->{
            int[] ls = Arrays.stream(arr).distinct().toArray();
            return Solution.builder().arr(Integer.parseInt(Arrays.toString(ls))).build();};
        Solution s = Solution.builder().build();
        System.out.println(f.solution(s));
    }

}