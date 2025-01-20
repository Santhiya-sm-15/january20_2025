class Solution {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    public void invert(TreeNode root)
    {
        if(root==null)
            return;
        if(root.left==null && root.right==null) 
            return;
        invert(root.left);
        invert(root.right);
        TreeNode t=root.left;
        root.left=root.right;
        root.right=t;
    }
}