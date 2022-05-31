package crp.kr.api.common.lambdas;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;
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
    public static int integer(String s){
        Function<String, Integer> f = Integer::parseInt;
        return f.apply(s);
    }
    public static long longParse(String s){
        Function<String, Long> f = Long::parseLong;
        return f.apply(s);
    }
    public static String string(Object o){
        Function<Object,String> f = String::valueOf;
        return f.apply(o);
    }
    public boolean equals(String s1, String s2){
        BiPredicate<String, String> p = String::equals;
        return p.test(s1, s2);
    }
    public static  int[] array(int i){
        Function<Integer, int[]> f = int[]::new;
        return f.apply(i);
    }

}
