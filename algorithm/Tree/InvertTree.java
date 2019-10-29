class InvertTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertMain(TreeNode tree) {
        if (tree == null) {
            return null;
        }
        TreeNode left = tree.left;
        TreeNode right = tree.right;

        // 左节点有儿子节点， 调用
        if (left != null) {
            invertMain(left);
        }
        // 右节点有儿子节点， 调用
        if (right != null) {
            invertMain(right);
        }
        // 交换左右节点
        invert(tree);

        return tree;
    }

    private void invert(TreeNode node) {
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (left != null || right != null) {
            node.left = right;
            node.right = left;
        }
    }
}