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