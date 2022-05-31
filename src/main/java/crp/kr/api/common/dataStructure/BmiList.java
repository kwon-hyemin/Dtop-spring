package crp.kr.api.common.dataStructure;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * packageName: crp.kr.api.common.dataStructure
 * fileName : BmiList
 * author  : 권혜민
 * date   : 2022-05-11
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-11     권혜민       최초 생성
 */
//키 height 몸무게 weight 생년월일 ssn (900101-1)
public class BmiList {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        AppleApp.AppleService service = new AppleApp.AppleServiceImpl();
        while(true){
            System.out.println("0.exit 1.save 2.update 3.delete 4.findById 5.findByOrigin 6.findAll 7.count 8.existsById 9.clear");
            switch (s.next()){
                case "0":return;
                case "1":
                    AppleApp.Apple yd = new AppleApp.Apple.Builder()
                            .origin("영동")
                            .color("RED")
                            .price(1000)
                            .build();
                    service.save(yd);
                    AppleApp.Apple yd2 = new AppleApp.Apple.Builder()
                            .origin("영동")
                            .color("BLUE")
                            .price(1500)
                            .build();
                    service.save(yd2);
                    AppleApp.Apple pg = new AppleApp.Apple.Builder()
                            .origin("풍기")
                            .color("RED")
                            .price(2000)
                            .build();
                    service.save(pg);

                    break;
                case "2":break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":
                    System.out.println("5.findByOrigin");
                    System.out.println(service.findByOrigin("영동"));
                    break;
                case "6":
                    System.out.println("6.findAll: \n"+service.findAll());
                    break;
                case "7":
                    System.out.println("총 회원수: "+service.count()+" 명");
                    break;
                case "8":break;
                case "9":
                    service.clear();
                    break;
                default:break;
            }
        }
    }

    @Data static class Bmi{
        protected String ssn;
        protected double height, weight;

        public Bmi(BmiList.Bmi.Builder builder) {
            this.ssn = builder.ssn;
            this.height = builder.height;
            this.weight = builder.weight;
        }
        @NoArgsConstructor
        static class Builder{
            protected String ssn;
            protected double height, weight;
            public Builder ssn(String ssn){this.ssn=ssn; return this;}
            public Builder height(double height){this.height=height; return this;}
            public Builder weight(double weight){this.weight=weight; return this;}
            BmiList.Bmi build(){ return new BmiList.Bmi(this);}
        }
        @Override public String toString(){
            return String.format("[사과 스펙] height: %d, weight: %d, ssn: %s",
                    height, weight, ssn);
        }
    }


    interface BmiService{
        void save(Bmi bmi);
        void update(int i, Bmi bmi);
        void delete(Bmi bmi);
        List<Bmi> findAll();
        List<Bmi> findByGender(String gender);
        Bmi findById(int i);
        int count();
        void clear();

    }

    static class BmiServiceimpl implements BmiService{
        private final List<Bmi> list;

        BmiServiceimpl() {
            this.list = new ArrayList<>();
        }

        @Override
        public void save(Bmi bmi) {
            list.add(bmi);
        }

        @Override
        public void update(int i, Bmi bmi) {
            list.set(i, bmi);
        }

        @Override
        public void delete(Bmi bmi) {
            list.remove(bmi);
        }

        @Override
        public List<Bmi> findAll() {
            return list;
        }

        @Override
        public List<Bmi> findByGender(String gender) {
            return null;
        }

        @Override
        public Bmi findById(int i) {
            return list.get(i);
        }

        @Override
        public int count() {
            return list.size();
        }

        @Override
        public void clear() {

        }
    }


}
