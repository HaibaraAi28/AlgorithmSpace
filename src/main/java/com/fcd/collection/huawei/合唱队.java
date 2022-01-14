package com.fcd.collection.huawei;

import java.util.Scanner;

/**
 *
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 *
 * 说明：
 *
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
 *
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 *
 *
 * 注意不允许改变队列元素的先后顺序
 * 请注意处理多组输入输出！
 *
 *
 * 输入描述:
 * 整数N
 *
 *
 *
 * 输出描述:
 * 最少需要几位同学出列
 *
 * 示例1
 * 输入
 * 8
 * 186 186 150 200 160 130 197 200
 * 输出
 * 4
 */
public class 合唱队 {

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/6d9d69e3898f45169a441632b325c7b4
     * 来源：牛客网
     *
     * 首先计算每个数在最大递增子串中的位置
     * 186 186 150 200 160 130 197 200 quene
     *
     * 1 1 1 2 2 1 3 4 递增计数
     *
     * 然后计算每个数在反向最大递减子串中的位置--->计算反向后每个数在最大递增子串中的位置
     *
     * 200 197 130 160 200 150 186 186 反向quene
     * 1 1 1 2 3 2 3 3 递减计数
     *
     * 然后将每个数的递增计数和递减计数相加
     *
     * 186 186 150 200 160 130 197 200 quene
     *
     * 1 1 1 2 2 1 3 4 递增计数
     *
     * 3 3 2 3 2 1 1 1 递减计数
     *
     * 4 4 3 5 4 2 4 5 每个数在所在队列的人数+1（自己在递增和递减中被重复计算）
     *
     * 如160这个数
     *
     * 在递增队列中有2个人数
     *
     * 150 160
     *
     * 在递减队列中有2个人数
     *
     * 160 130
     *
     * 那么160所在队列中就有3个人
     *
     * 150 160 130
     *
     * 每个数的所在队列人数表达就是这个意思
     *
     * 总人数 - 该数所在队列人数 = 需要出队的人数
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num = in.nextInt();
            if(num<=2){
                System.out.println(0);
            }
            int[] members=new int[num];//存储每一个数据元素
            int[] left_queue=new int[num];//数据元素从左到右对应的最大递增子序列数
            int[] right_queue=new int[num];//数据元素从右到左对应的最大递增子序列数
            for(int i=0;i<num;i++){//初始化各个数组数据
                members[i]=in.nextInt();
                left_queue[i]=1;
                right_queue[i]=1;
            }
            for(int i=0;i<num;i++){
                for(int j=0;j<i;j++){
                    if(members[i]>members[j]&&left_queue[j]+1>left_queue[i]) {
                        left_queue[i] = left_queue[j] + 1;
                    }
                }
            }
            for(int i=num-1;i>=0;i--){
                for(int j=num-1;j>i;j--){
                    if(members[i]>members[j]&&right_queue[j]+1>right_queue[i]) {
                        right_queue[i] = right_queue[j] + 1;
                    }
                }
            }
            int max=0;
            for(int i=0;i<num;i++){
                if(left_queue[i]+right_queue[i]>max) {
                    max = left_queue[i] + right_queue[i];
                }
            }
            System.out.println(num-max+1);
        }
    }
}
