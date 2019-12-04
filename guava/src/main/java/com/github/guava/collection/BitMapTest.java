package com.github.guava.collection;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午2:08 2019/12/4
 */
public class BitMapTest {

    private static final int RANDOM_SIZE = 64;

    public static void main(String[] args) {

        BitSet bitSet = new BitSet(64);
        Map<Integer, Integer> testMap = new HashMap<>(64);

        BitSet finalBitSet = bitSet;
        IntStream.range(0, 200000).forEach(i -> {
            finalBitSet.set(i);
            testMap.put(i, 0);
        });

        // 测试Map，循环200000次
        long mapStart = System.currentTimeMillis();
        Random mapRandom = new Random();
        for (int i = 0; i < 200000; i++) {
            int randomNum = mapRandom.nextInt(100000);
            // 判断返回值是否为Null, 为Null的话判断为false，否则为true
            testMap.get(randomNum);
        }
        System.out.println("hashmap execute time:" + (System.currentTimeMillis() - mapStart));


         // 测试BitSet，循环200000次
        long bitSetStart = System.currentTimeMillis();
        Random bitSetRandom = new Random();
        for (int i = 0; i < 200000; i++) {
            int randomNum = bitSetRandom.nextInt(100000);
            // 直接返回true/false
            bitSet.get(randomNum);
        }
        System.out.println("bitset execute time:" + (System.currentTimeMillis() - bitSetStart));


        Random random = new Random();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < RANDOM_SIZE; i++) {
            int randomResult = random.nextInt(RANDOM_SIZE);
            list.add(randomResult);
        }
        System.out.println("====== 产生的随机数有 ====== " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + "\t");
        }
         bitSet = new BitSet(RANDOM_SIZE);
        for (int i = 0; i < RANDOM_SIZE; i++) {
            bitSet.set(list.get(i));
        }

        System.out.println();
        System.out.println("====== 生成的随机数总数有 ====== " + bitSet.size());
        System.out.println("====== 不在生成随机数中的有 ====== ");
        for (int i = 0; i < RANDOM_SIZE; i++) {
            if (!bitSet.get(i)) {
                System.out.print(i  + "\t");
            }
        }

    }
}
