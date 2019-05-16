package com.stokey.algorithmdemo.Sword2Offer;

import java.util.Stack;

/**
 * Created by tiangen on 2017/5/24.
 */

public class D21MinInStack {
    /**
     * 包含min函数的栈
     * min/pop/push时间复杂度O(1)
     * 利用辅助栈(存储最小值元素)。如果当前入栈元素大于辅助栈顶元素，则向辅助栈中压入与栈顶元素相同的元素。
     * 如果当前入栈元素小于辅助栈顶元素，则向辅助栈中压入当前元素
     *
     * @param <T>
     */
    public static class SelfStack<T extends Comparable<T>> {
        private Stack<T> dataStack;
        private Stack<T> minStack;

        public SelfStack() {
            dataStack = new Stack<T>();
            minStack = new Stack<T>();
        }

        public void push(T value) {
            dataStack.push(value);
            T peek = null;
            if (!minStack.isEmpty()) {
                peek = minStack.peek();
            }
            if (peek == null || peek.compareTo(value) > 0) {
                minStack.push(value);
            } else {
                minStack.push(peek);
            }
        }

        public T pop() {
            if (dataStack.isEmpty() || minStack.isEmpty()) {
                throw new RuntimeException("stack is empty can't pop");
            } else {
                minStack.pop();
                return dataStack.pop();
            }
        }

        public T min() {
            if (minStack.empty()) {
                throw new RuntimeException("stack is empty can't min");
            }
            return minStack.pop();
        }
    }
}

class D21Test {
    public static void main(String[] args) {
        D21MinInStack.SelfStack<Integer> selfStack = new D21MinInStack.SelfStack<Integer>();
        selfStack.push(2);
        selfStack.push(10);
        selfStack.push(12);
        selfStack.push(1);
        selfStack.push(15);
        System.out.println("mini:" + selfStack.min());
        selfStack.pop();
        selfStack.pop();
        System.out.println("mini2:" + selfStack.min());
    }
}