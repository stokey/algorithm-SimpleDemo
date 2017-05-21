package com.stokey.algorithmdemo.Sword2Offer;

import java.util.Stack;

/**
 * Created by stokey on 2017/5/21.
 */

public class B07QueueWithTwoStacks {
    private class SpecialQueue {
        private Stack pushStack;
        private Stack popStack;

        public SpecialQueue() {
            pushStack = new Stack();
            pushStack.clear();
            popStack = new Stack();
            popStack.clear();
        }

        public void push(int i) {
            pushStack.push(i);
        }

        public int pop() {
            if (popStack.isEmpty() && pushStack.isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            } else {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
            return (int) popStack.pop();
        }
    }
}
