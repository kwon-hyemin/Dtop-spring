package crp.kr.api.common.dataStructure;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * packageName: crp.kr.api.common.dataStructure
 * fileName : Box
 * author  : 권혜민
 * date   : 2022-05-12
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-12     권혜민       최초 생성
 */
@Component @Data @Lazy // 순수자바 객체로 사용, Lazy DB가 필요 없다. 즉시 실행하지않고 호출 햇을때 실행한다 임시 저장소
//제네릭은 하나만 만들어서 넣어버리면 된다

public class Vector<T>{
    private ArrayList<T> list;
    // save update delete findAll findByName findById count existsById clear
    // add, set, remove, get(), X, get(i), size,X , clear

    public Vector(){this.list = new ArrayList<>();}
    public void add(T t){list.add(t);};
    public void set(int i, T t){list.set(i, t);}
    public void remove(T t){list.remove(t);}
    public ArrayList<T> get(){ return list;}
    public T get(int i){ return list.get(i);}
    public int size(){ return list.size();}
    public void clear(){list.clear();}

}
