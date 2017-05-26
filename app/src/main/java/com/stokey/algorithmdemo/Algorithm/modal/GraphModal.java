package com.stokey.algorithmdemo.Algorithm.modal;

import java.util.Vector;

/**
 * Created by stokey on 2017/5/27.
 */

public class GraphModal {
}

/**
 * 稠密图——邻接矩阵
 */
class DenseGraph {
    private int n; // 节点数
    private int m; // 边数
    private boolean isDirected; // 是否是有向图
    private boolean[][] g; // 图的具体数据

    public DenseGraph(int n, boolean isDirected) {
        assert (n >= 0);
        this.n = n;
        this.m = 0;
        this.isDirected = isDirected;
        g = new boolean[n][n];
    }

    /**
     * 获取节点数
     *
     * @return
     */
    public int V() {
        return this.n;
    }

    /**
     * 获取边数
     *
     * @return
     */
    public int E() {
        return this.m;
    }

    public void addEdge(int v, int w) {
        assert (v >= 0 && v < n);
        assert (w >= 0 && w < n);
        if (!hasEdge(v, w)) {
            this.g[v][w] = true;
            if (v != w && !isDirected) {
                this.g[w][v] = true;
            }
            this.m++;
        }
    }

    private boolean hasEdge(int v, int w) {
        assert (v >= 0 && v < n);
        assert (w >= 0 && w < n);
        return this.g[v][w];
    }
}


/**
 * 稀疏图——邻接表
 * 缺点：平行边hasEdge操作时间复杂度O(n)
 */
class SparseGraph {
    private int n; // 节点数
    private int m; // 边数
    private boolean isDirected; // 是否是有向图
    private Vector<Integer>[] g; // 图的具体数据

    public SparseGraph(int n, boolean isDirected) {
        assert (n >= 0);
        this.n = n;
        this.m = 0;
        this.isDirected = isDirected;
        for (int i = 0; i < n; i++) {
            g[i] = new Vector<>();
        }
    }

    public int V() {
        return this.n;
    }

    public int E() {
        return this.m;
    }

    public void addEdge(int v, int w) {
        assert (v >= 0 && v < n);
        assert (w >= 0 && w < n);

        if (!hasEdge(v, w)) {
            this.g[v].add(w);
            if (v != w && !this.isDirected) {
                this.g[w].add(v);
            }
            this.m++;
        }
    }

    private boolean hasEdge(int v, int w) {
        assert (v >= 0 && v < n);
        assert (w >= 0 && w < n);
        for (int i = 0; i < this.n; i++) {
            if (this.g[v].get(i) == w) {
                return true;
            }
        }
        return false;
    }


}