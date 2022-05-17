package crp.kr.api.common.dataStructure;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;


public class AppleList {
    public static void main(String[] args){    }

    @Data
    public static class Apple{
        private String color, origin;
        private int price;

        public Apple(Builder builder){
            this.color = builder.color;
            this.origin = builder.origin;
            this.price = builder.price;
        }
        @NoArgsConstructor
        static public class Builder {
            private String color, origin;
            private int price;
            public Builder color(String color) {this.color = color;return this;}
            public Builder origin(String origin) {this.origin = origin;return this;}
            public Builder price(int price) {this.price = price;return this;}
            public Apple build() {return new Apple(this);}
        }
        @Override
        public String toString() {
            return String.format("[사과 스펙] origin: %s, color: %s, price: %d",
                    origin, color, price);
        }
    }
    interface AppleService{
        void save(Apple apple);
        void update(int i, Apple apple);
        void delete(Apple apple);
        List<Apple> findAll();
        List<Apple> findByOrigin(String origin);
        List<Apple> findByColor(String color);
        Apple findById(int i);
        int count();
        void clear();
    }

    static class AppleServiceImpl implements AppleService{

        @Override
        public void save(Apple apple) {

        }

        @Override
        public void update(int i, Apple apple) {

        }

        @Override
        public void delete(Apple apple) {

        }

        @Override
        public List<Apple> findAll() {
            return null;
        }

        @Override
        public List<Apple> findByOrigin(String origin) {
            return null;
        }

        @Override
        public List<Apple> findByColor(String color) {
            return null;
        }

        @Override
        public Apple findById(int i) {
            return null;
        }

        @Override
        public int count() {
            return 0;
        }

        @Override
        public void clear() {

        }
    }
}
