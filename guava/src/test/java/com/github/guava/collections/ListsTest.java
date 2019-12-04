//package com.github.guava.collections;
//
//import com.google.common.base.Function;
//import com.google.common.collect.Interner;
//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;
//import org.junit.Test;
//
//import java.io.Serializable;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
///**
// * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
// * @Description:
// * @Date: Created in 下午3:23 2019/12/2
// */
//public class ListsTest {
//
//    private static final class CountFunction implements Function<String, Integer> {
//        int count = 1;
//
//        @Override
//        public Integer apply(String from) {
//            return (from.length() == 0) ? from : from.substring(1);
//        }
//    }
//
//    @Test
//    public void transform() {
//        List<String> list = Lists.newArrayList();
//
//
//
//        Map<String, Interner> map = list.stream().collect(Collectors.toMap(v1 -> v1, v2 -> 1, (v1, v2) -> v2));
//    }
//}
