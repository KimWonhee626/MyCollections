package org.example.MyArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyArrayListTest {

    @Test
    @DisplayName("size()")
    void t1(){
        MyArrayList<Object> list = new MyArrayList<>();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("add(\"element0\")")
    void t2(){
        MyArrayList<Object> list = new MyArrayList<>();
        list.add("element0");

        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("get(1)")
    void t3(){
        MyArrayList<Object> list = new MyArrayList<>();
        list.add("element0");
        list.add("element1");
        list.get(1);

        assertThat(list.get(1)).isEqualTo("element1");
    }

    @Test
    @DisplayName("리스트 크기 자동 증가")
    void t4(){
        MyArrayList<Object> list = new MyArrayList<>();
        for(int i = 0; i < 4; i++){
            list.add("element%d".formatted(i));
        }
    }
}
