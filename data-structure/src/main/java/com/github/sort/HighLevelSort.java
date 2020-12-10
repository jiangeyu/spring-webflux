package com.github.sort;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午10:07 2020/12/9
 */
public class HighLevelSort {

    public int[] num;
    int nElements;

    public HighLevelSort(int[] num) {
        this.num = num;
        nElements = 0;
    }

    public void shellSort() {
        int inner, outer, tmp, step = 1;
        while (step <= num.length / 3) {
            step = step * 3 + 1;
        }
        while (step > 0) {
            for (outer = step; outer < num.length; outer++) {
                tmp = num[outer];
                inner = outer;
                while (inner > step - 1 && num[inner - step] >= tmp) {
                    num[inner] = num[inner - step];
                    inner -= step;
                }
                num[inner] = tmp;
            }
            step = (step - 1) / 3;
        }
    }


    public void heapSort() {

    }

    public static void merge(int[] arrayA, int sizeA, int[] arrayB, int sizeB, int[] arrayC) {
        int aDex = 0, bDex = 0, cDex = 0;
        while (aDex < sizeA && bDex < sizeB) {
            if (arrayA[aDex] < arrayB[bDex]) {
                arrayC[cDex++] = arrayA[aDex++];
            } else {
                arrayC[cDex++] = arrayB[bDex++];
            }
        }

        while (aDex < sizeA) {
            arrayC[cDex++] = arrayA[aDex++];
        }
        while (bDex < sizeB) {
            arrayC[cDex++] = arrayB[bDex++];
        }
    }

    public void merge(int[] workerSpace, int lowBound, int highPtr, int upperBound) {
        int mid = highPtr - 1;
        int j = 0;
        int n = upperBound - lowBound + 1;
        int start = lowBound;
        while (lowBound <= mid && highPtr <= upperBound) {
            if (num[lowBound] < num[highPtr]) {
                workerSpace[j++] = num[lowBound++];
            } else {
                workerSpace[j++] = num[highPtr++];
            }
        }
        while (lowBound <= mid) {
            workerSpace[j++] = num[lowBound++];

        }
        while (highPtr <= upperBound) {
            workerSpace[j++] = num[highPtr++];
        }
        for (j = 0; j < n; j++) {
            num[start++] = workerSpace[j];
        }


    }


    private void recMergeSort(int[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        }
        int mid = (lowerBound + upperBound) / 2;
        recMergeSort(workSpace, lowerBound, mid);
        recMergeSort(workSpace, mid + 1, upperBound);

        merge(workSpace, lowerBound, mid + 1, upperBound);

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
//
        highLevelSort.shellSort();
//
//        highLevelSort.recMergeSort(new int[20], 0, 4);
        System.out.println(num.toString());

//        int[] num1 = new int[]{1, 6, 9, 20};
//        int[] num2 = new int[]{2, 3, 4, 5, 6, 9, 11};
//        int[] num3 = new int[11];
//        merge(num1, 4, num2, 7, num3);
//        System.out.println(num3.length);


    }
}
