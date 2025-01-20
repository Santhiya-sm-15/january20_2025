# january20_2025
The problems that I solved today

1.Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Code:
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

2.Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Code:
class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length,m=grid[0].length,cnt=0;
        boolean[][] visited=new boolean[n][m];
        int i,j;
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(!visited[i][j] && grid[i][j]=='1')
                {
                    cnt++;
                    count(i,j,grid,visited);
                }
            }
        }
        return cnt;
    }
    public void count(int i,int j,char[][] grid,boolean[][] visited)
    {
        int[][] dir={{0,-1},{-1,0},{0,1},{1,0}};
        int n=grid.length,m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j]=true;
        while(!q.isEmpty())
        {
            int[] x=q.poll();
            int r=x[0],c=x[1];
            for(int[] d:dir)
            {
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && !visited[nr][nc] && grid[nr][nc]=='1')
                {
                    q.add(new int[]{nr,nc});
                    visited[nr][nc]=true;
                }
            }
        }
    }
}

3.You are given a 0-indexed integer array arr, and an m x n integer matrix mat. arr and mat both contain all the integers in the range [1, m * n]. Go through each index i in arr starting from index 0 and paint the cell in mat containing the integer arr[i]. Return the smallest index i at which either a row or a column will be completely painted in mat. 

Code:
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer,int[]> mp=new HashMap<>();
        int i,j,n=mat.length,m=mat[0].length;
        int[] row=new int[n];
        int[] col=new int[m];
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                mp.put(mat[i][j],new int[]{i,j});
            }
        }
        for(i=0;i<arr.length;i++)
        {
            int[] x=mp.get(arr[i]);
            int r=x[0];
            int c=x[1];
            row[r]++;
            col[c]++;
            if(row[r]==m || col[c]==n)
                return i;
        }
        return 0;
    }
}

4.Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Code:
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

5.Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Code:
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

6.Given the root of a binary tree, invert the tree, and return its root.

Code:
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
