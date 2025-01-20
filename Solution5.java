class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> m=new HashMap<>();
        int n=inorder.length,i;
        for(i=0;i<n;i++)
            m.put(inorder[i],i);
        return build(postorder,0,n-1,inorder,0,n-1,m);
    }
    public TreeNode build(int[] postorder,int ps,int pe,int[] inorder,int is,int ie,Map<Integer,Integer> m)
    {
        if(ps>pe || is>ie)  
            return null;
        TreeNode root=new TreeNode(postorder[pe]);
        int x=m.get(postorder[pe]);
        int l=x-is;
        root.left=build(postorder,ps,ps+l-1,inorder,is,x-1,m);
        root.right=build(postorder,ps+l,pe-1,inorder,x+1,ie,m);
        return root;
    }
}