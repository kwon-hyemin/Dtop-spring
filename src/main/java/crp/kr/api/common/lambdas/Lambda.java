package crp.kr.api.common.lambdas;

import java.io.File;
import java.util.function.*;

/**
 * packageName: crp.kr.api.common.lambda
 * fileName : LambdaUtil
 * author  : 권혜민
 * date   : 2022-05-11
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-11     권혜민       최초 생성
 */
public class Lambda {
    public static void main(String[] args) {
    }
    //Function-apply  Consumer-accept
    //Predicate-test  Supplier-get
    // 객체 리턴 타입 int 파라미터 타입  String // 스트링타입 받고 인트타입객체로 변환 Integer::parseInt
    public static int Integer(String s){
        Function<String, Integer> f = Integer::parseInt;
        return f.apply(s);
    }
    // 리턴타입 String 파라미터 타입 Integer // 인트타입 받고 스트링 객체로 변환 String::valueOf;
    public static String string(Object s){
        Function<Object, String > f = String::valueOf;
        return f.apply(s);
    }
    // 리턴타입 boolean 파라미터 타입 String 두개비교 // 스트링타입 비교  String::equals;
    public static boolean bool(String s1,String s2){
        BiPredicate<String, String> p = String::equals;
        return p.test(s1,s2);
    }

    // int[] arr = new int[8]
    // =int[]::new
    // 이름은 array int[] 타입, size 8(파라미터)로 던지면 배열이 나온다.
    public static int[] arr(int i){
        Function<Integer, int[]> f = int[]::new;
        return f.apply(i);
    }

    //객체이름 random
    // int temp = (int)(d * 6)+1;
    // double d = Math.random();
    // return 값 int
    // int p = random(1, 6);
    // int player =(int)(Math.random()*6)+1;
    public static int random(int i1, int i2){
        BiFunction<Integer, Integer,Integer> f = (f1, f2) -> (int)(Math.random()*6)+1;
        return f.apply(i1,i2);
    }
    public static long longParse (String s) {
        Function<String, Long> f = Long::parseLong;
        return f.apply(s);
    }
}