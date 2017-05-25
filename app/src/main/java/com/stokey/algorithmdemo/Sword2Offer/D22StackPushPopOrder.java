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
        // TODO: 栈的压入、弹出序列
        if (push == null || pop == null || pop.length != push.length
                || pop.length == 0) {
            throw new RuntimeException("input sequence is error");
        }

        Stack<Integer> tempStack = new Stack<>();
        int indexPush = 0;
        int indexPop = 0;
        tempStack.push(push[indexPush]);
        while (indexPush < push.length && indexPop < pop.length) {
            if (!tempStack.isEmpty()) {
                if (tempStack.peek() == pop[indexPop]) {
                    tempStack.pop();
                    indexPop++;
                } else {
                    tempStack.push(push[++indexPush]);
                }
            }
        }
        return indexPop == indexPush;
    }
}
