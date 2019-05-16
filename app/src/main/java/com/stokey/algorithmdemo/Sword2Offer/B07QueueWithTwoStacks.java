package com.stokey.algorithmdemo.Sword2Offer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by stokey on 2017/5/21.
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，
 * 分别完成在队列尾部插入节点和在队列头部删除节点的功能。
 */

public class B07QueueWithTwoStacks {
    public static void main(String[] args) {
        SpecialQueue<Integer> specialQueue = new SpecialQueue<Integer>();
        specialQueue.push(0);
        specialQueue.push(1);
        specialQueue.push(2);

        while (!specialQueue.isEmpty()) {
            System.out.println("Queue pop:" + specialQueue.pop());
        }

        SpecialStack<Integer> specialStack = new SpecialStack<>();
        specialStack.push(1);
        specialStack.push(2);
        specialStack.push(3);
        while (!specialStack.isEmpty()) {
            System.out.println("Stack pop:" + specialStack.pop());
        }
    }
}

/**
 * 用两个栈实现队列
 *
 * @param <E>
 */
class SpecialQueue<E> {
    private Stack<E> pushStack;
    private Stack<E> popStack;

    public SpecialQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public boolean isEmpty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    public void push(E i) {
        pushStack.push(i);
    }

    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        } else {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }
}

/**
 * 用两个队列实现栈
 *
 * @param <E>
 */
class SpecialStack<E> {
    private LinkedList<E> queue1;
    private LinkedList<E> queue2;

    public SpecialStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public void push(E e) {
        if (isEmpty()) {
            queue1.add(e);
        } else if (queue1.isEmpty()) {
            queue2.add(e);
        } else {
            queue1.add(e);
        }
    }

    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        } else {
            if (queue1.isEmpty()) {
                final int length = queue2.size();
                for (int i = 0; i < length - 1; i++) {
                    queue1.add(queue2.remove());
                }
                return queue2.remove();
            } else if (queue2.isEmpty()) {
                final int length = queue1.size();
                for (int i = 0; i < length - 1; i++) {
                    queue2.add(queue1.remove());
                }
                return queue1.remove();
            }
        }
        return null;
    }
}
