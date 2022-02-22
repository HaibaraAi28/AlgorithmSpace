package com.base.algorithmlclass.sort;

/**
 * 快排不稳定
 */
public class PartitionAndQuickSort {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }

    // arr[L...R] 玩荷兰国旗问题的划分，以arr[R]做划分值
    // 分成3部分
    //  <arr[R]  ==arr[R]  > arr[R]
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[] { -1, -1 };
        }
        if (L == R) {
            return new int[] { L, R };
        }
        int less = L - 1; // < 区 右边界
        int more = R;     // > 区 左边界
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else { // >
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R);
        return new int[] { less + 1, more };
    }

    /**
     * 快排1.0
     * @param arr
     */
    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }

    /**
     * 通过partition方法，以数组尾部为标准num，将数组指定范围内分成<=num和>=num两部分
     * 再对两个部分递归partition
     * @param arr
     * @param L
     * @param R
     */
    public static void process1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        // L..R partition arr[R]  [   <=arr[R]   arr[R]    >arr[R]  ]
        int M = partition(arr, L, R);
        process1(arr, L, M - 1);
        process1(arr, M + 1, R);
    }

    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    /**
     * netherlandsFlag，以数组尾部为标准num，将数组指定范围内分成<=num，=num和>=num两部分
     * 再对前后两个部分递归netherlandsFlag
     */
    public static void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equalArea = netherlandsFlag(arr, L, R);
        process2(arr, L, equalArea[0] - 1);
        process2(arr, equalArea[1] + 1, R);
    }

    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    /**
     * 随机选个数作为第一个标准值
     * @param arr
     * @param L
     * @param R
     */
    public static void process3(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] equalArea = netherlandsFlag(arr, L, R);
        process3(arr, L, equalArea[0] - 1);
        process3(arr, equalArea[1] + 1, R);
    }

    /**
     * 快排常规写法
     * @param arr
     */
    public static void myQuickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length -1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }

        int left = low;
        int right = high;
        int pivot = arr[low]; //默认最左边作为基准数

        while(left < right) { //(0,left)小于等于pivot,(left+1,right)大于pivot
            while (arr[right] >= pivot && left < right) {
                right--; //找到右侧第一个小于pivot的下标
            }

            while (arr[left] <= pivot && left < right) {
                left++; //找到左侧第一个大于pivot的下标
            }

            //交换两者位置
            if (left < right) {
                swap(arr, left, right);
            }
        }

        //交换arr[left]与arr[low],使基准数处于中间，完成第一次遍历
        arr[low] = arr[left];
        arr[left] = pivot;

        //对基准数前后两部分进行递归排序
        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            quickSort1(arr1);
            quickSort2(arr2);
            quickSort3(arr3);
            if (!isEqual(arr1, arr2) || !isEqual(arr2, arr3)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Oops!");

    }
}
