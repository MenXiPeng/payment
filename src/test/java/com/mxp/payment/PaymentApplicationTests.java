package com.mxp.payment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

//@SpringBootTest
class PaymentApplicationTests {


    private static final Integer SPLIT_NUM = 11;


    @Test
    void contextLoads() {
        Set<Integer> phonesValidSet = new HashSet<>();

        for (int i = 0; i < 1000; i++) {
            phonesValidSet.add(i);
        }


        if (phonesValidSet.size() > SPLIT_NUM) {
            var num = phonesValidSet.size() / SPLIT_NUM;
            for (int i = 0; i < num + 1; i++) {
                var list = phonesValidSet.stream().skip(SPLIT_NUM * i).limit(SPLIT_NUM).collect(Collectors.toList());
                if (list.isEmpty()) {
                    break;
                }
                System.out.println(list);
            }
        }else {
            System.out.println(phonesValidSet);
        }

    }

    @Test
    public void demo(){
        System.out.println("qwerfvbg".hashCode());
        System.out.println("qwerfvbg".hashCode());
        //new HashMap<>()
    }

}
