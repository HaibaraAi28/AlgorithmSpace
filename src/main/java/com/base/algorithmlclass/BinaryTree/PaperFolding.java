package com.base.algorithmlclass.BinaryTree;

/**
 * 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展 开。此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
 *
 * 给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
 *
 * 测试样例：
 * 1
 * 返回：["down"]
 * 2
 * 返回：["down", "down", "up"]
 *
 * 思路：
 * 实现先后再中，最后左的中序遍历即可得到所有折痕的打印顺序。（特殊的中序遍历）
 */
public class PaperFolding {
    public static void printAllFolds(int N) {
        printProcess(1, N, true);
    }

    // 递归过程，来到了某一个节点，
    // i是节点的层数，N一共的层数，down == true  凹    down == false 凸
    public static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, true);
        System.out.println(down ? "凹 " : "凸 ");
        printProcess(i + 1, N, false);
    }

    public static void main(String[] args) {
        int N = 3;
        printAllFolds(N);
    }
}
