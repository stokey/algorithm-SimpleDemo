package com.stokey.algorithmdemo.Sword2Offer;

import java.util.Stack;

/**
 * Created by tiangen on 2017/5/24.
 */

public class D22StackPushPopOrder {

    /**
     * 输入两个整数序列，第一个序列表示压入顺序
     * 判断第二个序列是否为该栈的弹出顺序
     *
     * @param push
     * @param pop
     * @return
     */
    public static boolean isOrder(int[] push, int[] pop) {
        if (push == null || pop == null || pop.length != push.length
                || pop.length == 0) {
            throw new RuntimeException("input sequence is error");
        }

        Stack<Integer> tempStack = new Stack<>();
        int indexPush = 0;
        int indexPop = 0;
        // 将push数组第一个元素压到临时栈中
        tempStack.push(push[indexPush++]);
        while (indexPop < pop.length) {
            if (!tempStack.isEmpty()) {
                // 判断临时栈顶元素是否和当前代出栈元素相等，相等则同时出栈，否则继续将元素压进临时栈中
                if (tempStack.peek() == pop[indexPop]) {
                    tempStack.pop();
                    ++indexPop;
                } else {
                    if (indexPush < push.length) {
                        tempStack.push(push[indexPush]);
                        ++indexPush;
                    } else {
                        return false;
                    }
                }
            } else {
                break;
            }
        }
        // 当出栈次数等于入栈次数时则表示第二个序列是该栈的弹出顺序
        return indexPop == indexPush;
    }
}

class D22Test {
    public static void main(String[] args) {
        System.out.println("第二个序列是第一个序列的弹出序列：" + D22StackPushPopOrder.isOrder(new int[]{1, 2, 3, 4, 6}, new int[]{4, 6, 3, 2, 1}));
        System.out.println("第二个序列是第一个序列的弹出序列：" + D22StackPushPopOrder.isOrder(new int[]{1, 2, 3, 4, 6}, new int[]{7, 6, 7, 2, 1}));
    }
}