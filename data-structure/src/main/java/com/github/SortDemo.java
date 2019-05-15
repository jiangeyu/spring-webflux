package com.github;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:36 2019/5/12
 */
public class SortDemo {

    public static void heapSort(int[] array) {
        for (int i = array.length / 2; i > 0; i--) {
            heapAdjust(array, i, array.length);
        }

        for (int j = array.length; j > 0; j--) {
            swap(array, 1, j);
            heapAdjust(array, 1, j - 1);
        }
    }

    public static void heapAdjust(int[] a, int s, int m) {
        int temp, j;
        temp = a[0];
        for (j = 2 * s; j <= m; j *= 2) {
            if (j < m && a[j] > a[j + 1]) {
                ++j;
            }
            if (temp > a[j]) {
                break;
            }
            a[s] = a[j];
            s = j;
        }
        a[s] = temp;
    }

    public static void swap(int[] a, int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
