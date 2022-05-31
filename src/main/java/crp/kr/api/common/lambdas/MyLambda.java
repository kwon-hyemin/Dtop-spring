package crp.kr.api.common.lambdas;

/**
 * packageName: crp.kr.api.common.lambda
 * fileName : MyLambda
 * author  : 권혜민
 * date   : 2022-05-13
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-13     권혜민       최초 생성
 */
public class MyLambda {
    // 커스텀 한다는 뜻
    @FunctionalInterface interface MyInterface{String myMethod();}// supplier

    @FunctionalInterface interface MyFunction{int execute(String arg);}
    @FunctionalInterface interface MyConsumer{void execute(int i);}
    @FunctionalInterface interface MySupplier{int execute();}
    @FunctionalInterface interface MyPredicate{boolean execute(String arg);}
    @FunctionalInterface interface MyUnaryOp{int operator(Integer a);}
    @FunctionalInterface interface LengthOfString{int execute(String arg);} //비밀번호 몇개 이상
    @FunctionalInterface interface MathOperation{int execute(int a, int b);}

}