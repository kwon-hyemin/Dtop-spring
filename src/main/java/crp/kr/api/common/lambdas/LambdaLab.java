package crp.kr.api.common.lambdas;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

/**
 * packageName: crp.kr.api.common.lambdas
 * fileName : LambdaLab
 * author  : 권혜민
 * date   : 2022-05-26
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-26     권혜민       최초 생성
 */
public class LambdaLab {

    public static String solution(){
//        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Supplier<String> s = () -> (new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        return s.get();
    }
    @Test
    public void testSolution(){
        System.out.println(solution());
    }

}
