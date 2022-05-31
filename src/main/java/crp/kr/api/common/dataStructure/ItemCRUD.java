package crp.kr.api.common.dataStructure;

import crp.kr.api.soccer.domains.Schedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

/**
 * packageName: crp.kr.api.common.dataStructure
 * fileName : ItemCRUD
 * author  : 권혜민
 * date   : 2022-05-10
 * desc   :
 * ================================
 * DATE        AUTHOR       NOTE
 * ================================
 * 2022-05-10     권혜민       최초 생성
        */
public class ItemCRUD {
    public static void main(String[] args) {}
    @Data @AllArgsConstructor class Item{}
    interface ItemService{}
    @RequiredArgsConstructor class ItemServiceimpl implements ItemService{}
}
