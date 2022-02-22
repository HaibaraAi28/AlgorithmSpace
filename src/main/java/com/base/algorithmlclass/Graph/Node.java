package com.base.algorithmlclass.Graph;

import java.util.ArrayList;

/**
 * 点结构的描述  A  0
 */
public class Node {
    public int value;
    public int in; //入度，指向该节点的个数
    public int out; //出度
    public ArrayList<Node> nexts; //直接邻居，由自己出发可达的节点
    public ArrayList<Edge> edges; //从自己出发的边

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
