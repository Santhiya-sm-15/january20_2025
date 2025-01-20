class Solution {
    int x=1;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)
            return -1;
        int l=kthSmallest(root.left,k);
        if(l!=-1)
            return l;
        if(x==k)
            return root.val;
        x++;
        int r=kthSmallest(root.right,k);
        if(r!=-1)
            return r;
        return -1;
    }
}