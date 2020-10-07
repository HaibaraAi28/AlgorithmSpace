package com.fcd.classics;

/**
 * 从n个不同元素中任取m（m≤n）个元素，按照一定的顺序排列起来，叫做从n个不同元素中取出m个元素的一个排列。当m=n时所有的排列情况叫全排列。
 *
 * 例如：将 数组 { 1，2，3}进行全排列
 *
 * 首先，我们需要知道当只有一个元素进行全排列的时候，全排列就等于它本身。
 *
 * 这个数组的全排列就是需要将 每个元素放到数组首部，然后将剩下的元素进行全排列，依照此思路我们可以用递归很快的写出代码。
 *
 * 如果需要全排列按照字典序输出的话，只需要将需要全排列的数组先进行排序，然后再求全排列就好。
 *
 * 体思想就是将这个数组里面的每个元素都放在第一位一次，将剩下的元素进行全排列，层层递归，直至只有一个元素为止。
 */
public class FullPermutation {
    public void pringArray(int [] arr,int n){
        // 打印数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public void swap(int [] arr,int i,int j){
        // 交换函数
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // 对数组arr进行全排列
    public void perum(int [] arr,int p,int q ){
        // for循环将数组中所有的元素和第一个元素进行交换。然后进行全排列。
        // 递归结束条件
        if(p == q){
            //  一次递归结束。将整个数组打印出来
            pringArray( arr,q+1);
        }
        for(int i =p ;i <= q;i++){
            swap(arr,i,p);
            // 把剩下的元素都做全排列。
            perum(arr,p+1,q);
            // 然后再交换回去，数组还原，保证下一次不会有重复交换。
            swap(arr,i,p);
        }
    }

    public static void main(String[] args) {
        int arr[] ={1,2,3};
        FullPermutation practice_perum = new FullPermutation();
        practice_perum.perum(arr,0,arr.length-1);
    }
}
