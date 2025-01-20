class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> m=new HashMap<>();
        int n=inorder.length,i;
        for(i=0;i<n;i++)
            m.put(inorder[i],i);
        return build(preorder,0,n-1,inorder,0,n-1,m);
    }
    public TreeNode build(int[] preorder,int ps,int pe,int[] inorder,int is,int ie,Map<Integer,Integer> m)
    {
        if(ps>pe || is>ie)  
            return null;
        TreeNode root=new TreeNode(preorder[ps]);
        int x=m.get(preorder[ps]);
        int l=x-is;
        root.left=build(preorder,ps+1,ps+l,inorder,is,x-1,m);
        root.right=build(preorder,ps+l+1,pe,inorder,x+1,ie,m);
        return root;
    }
}