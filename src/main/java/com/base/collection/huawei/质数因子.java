package com.base.collection.huawei;

import java.util.Scanner;

/**
 *
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 *
 * 最后一个数后面也要有空格
 *
 *
 * 输入描述:
 * 输入一个long型整数
 *
 *
 *
 * 输出描述:
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 *
 * 示例1
 * 输入
 * 180
 * 输出
 * 2 2 3 3 5
 */
public class 质数因子 {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        long number = 0;

        while(scanner.hasNextLong())
        {
            number = scanner.nextLong();
            isPrimerFactors(number);
        }

    }

    private static void isPrimerFactors(long num)
    {
        long number = num;
        while(number != 1)
        {
            for(int i = 2; i <= number ;i++)
            {
                if(number % i == 0)
                {
                    number /= i;
                    System.out.print(i + " ");
                    break;
                }
            }
        }
    }
}
