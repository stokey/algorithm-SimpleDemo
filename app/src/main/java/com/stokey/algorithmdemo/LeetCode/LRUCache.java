package com.stokey.algorithmdemo.LeetCode;

import com.stokey.algorithmdemo.Algorithm.model.Node;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }

    private Map<Integer, Node> map;
    private Node<Integer, Integer> head;
    private Node<Integer, Integer> tail;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        Node n = map.get(key);
        if (n == null) {
            return -1;
        }
        moveToFirst(n);
        return (int) n.value;
    }

    public void put(int key, int value) {
        Node n = map.get(key);
        if (n == null) {
            if (map.size() >= capacity) {
                map.remove(tail.key);
                removeLast();
            }
            n = new Node(key, value);
        }
        n.value = value;
        moveToFirst(n);
        map.put(key, n);
    }

    private void removeLast() {
        if (tail != null) {
            tail = tail.leftNode;
            if (tail == null) {
                head = null;
            } else {
                tail.rightNode = null;
            }
        }
    }

    private void moveToFirst(Node n) {
        if (n == head) {
            return;
        }
        if (n.leftNode != null) {
            n.leftNode.rightNode = n.rightNode;
        }
        if(n.rightNode != null) {
            n.rightNode.leftNode = n.leftNode;
        }

        if (n == tail) {
            tail = n.leftNode;
        }

        if (head == null || tail == null) {
            head = tail = n;
            return;
        }

        n.rightNode = head;
        head.leftNode = n;
        head = n;
        n.leftNode = null;
    }
}

class LRUCache2 {
    private final int capacity;
    private Map<Integer, Integer> cache;

    public LRUCache2(final int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            // 定义put后的移除规则，大于容量就删除eldest
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }
    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        cache.put(key, value);
    }
}