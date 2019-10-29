public class MergeTrees {
    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    public TreeNode Solution (TreeNode t1, TreeNode t2) {
        TreeNode left1 = null, right1 = null;
        TreeNode left2 = null, right2 = null;
        int leftV = 0, rightV = 0;
        if (t1 != null) {
            left1 = t1.left;
            right1 = t1.right;
            leftV = t1.val;
        }
        if (t2 != null) {
            left2 = t2.left;
            right2 = t2.right;
            rightV = t2.val;
        }

        if (t1 == null && t2 == null) {
            return null;
        }


        TreeNode nTnode = new TreeNode(leftV + rightV);
        if (left1 != null || left2 != null) {
            nTnode.left = Solution(left1, left2);
        } else {
            nTnode.left = null;
        }

        if (right1 != null || right2 != null) {
            nTnode.right = Solution(right1, right2);
        } else {
            nTnode.right = null;
        }

        return nTnode;
    }
}
