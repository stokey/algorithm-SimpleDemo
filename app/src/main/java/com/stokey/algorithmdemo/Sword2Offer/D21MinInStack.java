package com.stokey.algorithmdemo.Sword2Offer;

import java.util.Stack;

/**
 * Created by tiangen on 2017/5/24.
 */

public class D21MinInStack {
    /**
     * 包含min函数的栈
     * min/pop/push时间复杂度O(1)
     * @param <T>
     */
    class SelfStack<T extends Comparable<T>> {
        private Stack<T> dataStack;
        private Stack<T> minStack;

        public SelfStack() {
            dataStack = new Stack();
            dataStack.clear();
            minStack = new Stack();
            minStack.clear();
        }

        public void push(T value) {
            dataStack.push(value);
            T peek = minStack.peek();
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

        public T min(){
            if (minStack.empty()){
                throw new RuntimeException("stack is empty can't min");
            }
            return minStack.pop();
        }
    }
}
