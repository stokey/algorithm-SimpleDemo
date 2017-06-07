package com.stokey.algorithmdemo.Sword2Offer;

/**
 * Created by tiangen on 2017/6/7.
 */

import java.util.LinkedList;

/**
 * 约瑟夫（Josephuse）环问题
 * <p>
 * 解法1：用环形链表模拟圆圈
 * 解法2：分析每次被删除的数字的规律并直接计算出圆圈中最后剩下的数字
 */
public class F45LastNumberInCircle {
    /**
     * 0，1，...，n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。
     * 求出这个圆圈里面剩下的最后一个数字
     * 用LinkedList代替环形链表
     * 时间复杂度O(nm)，空间复杂度O(n)
     *
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.push(i);
        }
        int idx = 0;
        while (list.size() > 1) {
            // 只要移动m-1次就可以移动到下一个要删除的元素上
            for (int i = 1; i < m; i++) {
                ++idx;
                idx = idx % list.size();
            }
            list.remove(idx);
        }
        return list.pop();
    }

    /**
     * 0，1，...，n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。
     * 求出这个圆圈里面剩下的最后一个数字
     * <p>
     * 【n个人（编号0~(n-1))，从0开始报数，报到(m-1)的退出，剩下的人继续从0开始报数。求胜利者的编号。
     * 我们知道第一个人(编号一定是m%n-1) 出列之后，剩下的n-1个人组成了一个新的约瑟夫环（以编号为k=m%n的人开始）
     * k k+1 k+2 ... n-2, n-1, 0, 1, 2, ... k-2并且从k开始报0。现在我们把他们的编号做一下转换：
     * k     --> 0
     * k+1   --> 1
     * k+2   --> 2
     * ...
     * k-2   --> n-2
     * k-1   --> n-1
     * 变换后就完完全全成为了(n-1)个人报数的子问题
     * =====> f(1) = 0; f(n) = (f(n-1)+m)%size】
     * <p>
     * 时间复杂度O(n)，空间复杂度O(1)
     */
    public static int lastRemainingAdvance(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
