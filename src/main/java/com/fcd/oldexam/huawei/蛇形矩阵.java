package com.fcd.oldexam.huawei;

import java.util.Scanner;

/**
 *
 * 蛇形矩阵，作为一种常用的数字数列，是由1开始的自然数一次排列成的一个N*N的正方形矩阵，数字依次由外而内的递增，如下面实例：
 * n=3的蛇形矩阵
 * 1 2 3
 * 8 9 4
 * 7 6 5
 * n=6的蛇行矩阵
 * 1 2 3 4 5 6
 * 20 21 22 23 24 7
 * 19 32 33 34 25 8
 * 18 31 36 35 26 9
 * 17 30 29 28 27 10
 * 16 15 14 13 12 11
 * 此题要求输入蛇形矩阵宽度N，输出整个蛇形矩阵结果，注意输出格式要求按照矩阵从上至下的依次按行输出，每行中间无需换行输出。
 *
 * 输入描述:
 * 输入为一个数字N，即蛇形矩阵的宽度(1 ≤ N ≤ 20)。
 *
 *
 * 输出描述:
 * 输出一行N阶蛇形矩阵的值，以空格分割。行末无空格。
 * 示例1
 * 输入
 * 3
 * 输出
 * 1 2 3 8 9 4 7 6 5
 */
public class 蛇形矩阵 {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter n:");
        int n=sc.nextInt();
        printJZ(n);
    }

    public static void printJZ(int n){
        int [][]A=new int[n][n];
        int t=1;
        int i=0;
        int j=0;
        for(int k=0;k<n/2;k++){//k代表第几圈
            for(i=k,j=k;j<n-k-1;j++){//第一条边
                A[i][j]=t++;
            }
            for(i=k,j=n-k-1;i<n-k-1;i++){//第二条边
                A[i][j]=t++;
            }
            for(i=n-k-1,j=n-k-1;j>k;j--){//第三条边
                A[i][j]=t++;
            }
            for(i=n-k-1,j=k;i>k;i--){//第四条边
                A[i][j]=t++;
            }


        }
        if(n%2==1){
            A[n/2][n/2]=t;
        }

        for(i=0;i<n;i++){
            for (j=0;j<n;j++) {
                System.out.print(A[i][j]+" ");
            }
            //System.out.println();
        }
    }

}
