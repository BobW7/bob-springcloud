package com.bob.consumer;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public static int pseudoPalindromicPaths(TreeNode root) {
        //定义每条路径和当前路径
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        //调用辅助方法遍历路径并存储
        traversePaths(root, paths, currentPath);
        int res = 0;
        //遍历每条路径
        for (List<Integer> path : paths) {
            //判断是否回文（写个函数）
            if (isPseudoPalindromic(path)) {
                res++;
            }
        }
        return res;
    }

    public static void traversePaths(TreeNode node, List<List<Integer>> paths, List<Integer> currentPath) {
        if (node == null) {
            return;
        }
        currentPath.add(node.val);//将当前节点的值添加到当前路径

        // 到达叶节点时，将当前路径添加到路径列表中
        if (node.left == null && node.right == null) {
            paths.add(new ArrayList<>(currentPath));
        }

        //递归遍历左子树和右子树
        traversePaths(node.left, paths, currentPath);
        traversePaths(node.right, paths, currentPath);

        //移除当前节点的值，回到上一层
        currentPath.remove(currentPath.size() - 1);
    }

    public static boolean isPseudoPalindromic(List<Integer> path) {
        int[] counts = new int[10]; // 用于计数每个数字（0-9）出现的次数

        // 统计路径中每个数字的出现次数
        for (int num : path) {
            counts[num]++;
        }

        int oddCount = 0; // 奇数次出现的数字的数量

        // 检查路径是否是伪回文的
        for (int count : counts) {
            if (count % 2 != 0) { // 如果数字出现次数为奇数
                oddCount++;
            }
        }
        return oddCount <= 1; // 如果最多只有一个数字出现次数为奇数，则返回true
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        System.out.println(Solution.pseudoPalindromicPaths(root));
    }
}
