package com.github.sort;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午10:07 2020/12/9
 */
public class HighLevelSort {

    public int[] num;

    public HighLevelSort(int[] num) {
        this.num = num;
    }

    public void quickSort(int left, int right) {
        if (right - left <= 0) {
            return;
        }
        int pivot = num[right];
        int partition = partition(left, right, pivot);
        quickSort(left, partition - 1);
        quickSort(partition + 1, right);
    }


    public int partition(int left, int right, int pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (num[++leftPtr] < pivot) {
            }
            while (rightPtr > 0 && num[--rightPtr] > pivot) {
            }
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right);
        return leftPtr;
    }

    public void swap(Integer index1, Integer index2) {
        int tmp = num[index1];
        num[index1] = num[index2];
        num[index2] = tmp;
    }


    public static void main(String[] args) {
        int[] num = {1, 9, 8, 2, 6};

        HighLevelSort highLevelSort = new HighLevelSort(num);


        highLevelSort.quickSort(0, 4);
        System.out.println(num.toString());

    }
}
