package com.github.sort;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午7:36 2019/5/30
 */
public class SimpleSortDemo {

    public static int[] insertSort(int[] a) {

        for (int out = 1; out < a.length; out++) {
            int tmp = a[out];
            int in = out;
            while ((in > 0) && a[in - 1] >= tmp) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = tmp;
        }
        return a;
    }

    public static void swap(int one, int two, int[] a) {
        int tmp = a[one];
        a[one] = a[two];
        a[two] = tmp;

    }

    public static int[] bubbleSort(int[] a) {
        int length = a.length;
        for (int i = length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(j, j + 1, a);
                }
            }

        }
        return a;
    }

    public static int[] selectSort(int[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }

            }
            swap(i, min, a);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {1, 9, 8, 2, 6};
        int[] b = insertSort(a);
        for (int n = 0; n < b.length; n++) {
            System.out.println(b[n]);
        }
        System.out.println("------");
//        for (int i : b) {
//            System.out.println(i);
//        }
//        System.out.println("-----");
//        Arrays.stream(b).forEach(System.out::println);
//
//        IntStream.of(a).forEach(System.out::println);

//        char p = '+';
//        char m = '-';
//        System.out.println(p + m);

    }
}
