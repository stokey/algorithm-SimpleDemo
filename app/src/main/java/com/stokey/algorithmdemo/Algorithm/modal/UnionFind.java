package com.stokey.algorithmdemo.Algorithm.modal;

/**
 * Created by stokey on 2017/5/26.
 */

public class UnionFind {

}

/**
 * 并查集的一种实现，find函数时间复杂度O(1),union函数复杂度为O(n)
 */
class QuickFind {
    private int[] id;
    private int count;

    public QuickFind(int count) {
        this.count = count;
        this.id = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        assert (p >= 0 && p < count);
        return this.id[p];
    }

    public boolean isConnected(int p, int q) {
        assert (p >= 0 && p < count && q >= 0 && q < count);
        return this.id[p] == this.id[q];
    }

    public void union(int p, int q) {
        assert (p >= 0 && p < count && q >= 0 && q < count);
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }

        for (int i = 0; i < count; i++) {
            if (this.id[i] == pID) {
                this.id[i] = qID;
            }
        }
    }
}

/**
 * 并查集的一种实现方式，union函数时间复杂度O(1)
 */
class QuickUnion {
    private int count;
    private int[] parent;
    public QuickUnion(int count) {
        assert (count > 0);
        this.count = count;
        this.parent = new int[count];
        for (int i = 0; i < count; i++) {
            this.parent[i] = i;
        }
    }

    public int find(int p) {
        assert (p >= 0 && p < this.count);
        // 指向自身时表示已经达到根节点
        while (p != this.parent[p]) {
            p = this.parent[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        assert (p >= 0 && p < count && q >= 0 && q < count);
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (qRoot == pRoot) {
            return;
        }
        this.parent[qRoot] =  pRoot;
    }
}

/**
 * 并查集优化1
 * 通过记录每个节点拥有的子节点个数,优化union操作
 */
class QuickUnionAdvance1 {
    private int count;
    private int[] parent;
    private int[] sz;// 当前节点距根节点元素个数
    public QuickUnionAdvance1(int count) {
        assert (count > 0);
        this.count = count;
        this.parent = new int[count];
        this.sz = new int[count];
        for (int i = 0; i < count; i++) {
            this.parent[i] = i;
            this.sz[i]=1;
        }
    }

    public int find(int p) {
        assert (p >= 0 && p < this.count);
        // 指向自身时表示已经达到根节点
        while (p != this.parent[p]) {
            p = this.parent[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        assert (p >= 0 && p < count && q >= 0 && q < count);
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (qRoot == pRoot) {
            return;
        }

        if(this.sz[pRoot] < this.sz[qRoot]) {
            this.parent[pRoot] = qRoot;
            this.parent[qRoot] += this.parent[pRoot];
        } else {
            this.parent[qRoot] = pRoot;
            this.parent[pRoot] += this.parent[qRoot];
        }
    }
}

/**
 * 并查集优化2
 * 通过记录当前节点所在树的高度，优化union操作
 */
class QuickUnionAdvance2 {
    private int count;
    private int[] parent;
    private int[] rank;// 当前节点所在树的高度
    public QuickUnionAdvance2(int count) {
        assert (count > 0);
        this.count = count;
        this.parent = new int[count];
        this.rank = new int[count];
        for (int i = 0; i < count; i++) {
            this.parent[i] = i;
            this.rank[i]=1;
        }
    }

    public int find(int p) {
        assert (p >= 0 && p < this.count);
        // 指向自身时表示已经达到根节点
        while (p != this.parent[p]) {
            p = this.parent[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        assert (p >= 0 && p < count && q >= 0 && q < count);
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (qRoot == pRoot) {
            return;
        }

        if(this.rank[pRoot] < this.rank[qRoot]) {
            this.parent[pRoot] = qRoot;
        } else if (this.rank[pRoot] > this.rank[qRoot]){
            this.parent[qRoot] = pRoot;
        } else {
            this.parent[pRoot] = qRoot;
            this.rank[qRoot] += 1;
        }
    }
}

/**
 * 并查集优化3
 * 优化find操作【路径压缩，时间复杂度近乎O(1)】，以减少树的高度
 */
class QuickUnionAdvance3 {
    private int count;
    private int[] parent;
    private int[] rank;// 当前节点所在树的高度
    public QuickUnionAdvance3(int count) {
        assert (count > 0);
        this.count = count;
        this.parent = new int[count];
        this.rank = new int[count];
        for (int i = 0; i < count; i++) {
            this.parent[i] = i;
            this.rank[i]=1;
        }
    }

    public int find(int p) {
        assert (p >= 0 && p < this.count);
        // 指向自身时表示已经达到根节点
        /*
        // 路径压缩
        while (p != this.parent[p]) {
            // 当该节点不是根节点时
            // 路径压缩
            this.parent[p] = this.parent[this.parent[p]];
            p = this.parent[p];
        }
        return p;
        */

        // 理论最优压缩
        while (p != this.parent[p]){
            this.parent[p] = find(this.parent[p]);
        }
        return this.parent[p];
    }

    public boolean isConnected(int p, int q) {
        assert (p >= 0 && p < count && q >= 0 && q < count);
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (qRoot == pRoot) {
            return;
        }

        if(this.rank[pRoot] < this.rank[qRoot]) {
            this.parent[pRoot] = qRoot;
        } else if (this.rank[pRoot] > this.rank[qRoot]){
            this.parent[qRoot] = pRoot;
        } else {
            this.parent[pRoot] = qRoot;
            this.rank[qRoot] += 1;
        }
    }
}