class Solution
{
    List<List<String>> board;
    public List<List<String>> solveNQueens(int n)
    {
        board=new ArrayList<>();

        int[][] attacks=new int[n][n];
        for(int row[]:attacks)
            Arrays.fill(row,-1);

        nQueens(0,n,attacks,new ArrayList<>());
        return board;
    }

    void nQueens(int i,int n,int[][] attacks,List<String> pos)
    {
        if(i==n)
        {
            board.add(new ArrayList<>(pos));
            return;
        }

        char []sb=new char[n];
        Arrays.fill(sb,'.');
        for(int j=0;j<n;j++)
        {
            if(attacks[i][j]!=-1)
                continue;
            
            setAttack(i,j,n,attacks,i,-1);
            sb[j]='Q';
            pos.add(new String(sb));
            nQueens(i+1,n,attacks,pos);
            pos.remove(pos.size()-1);
            sb[j]='.';
            setAttack(i,j,n,attacks,-1,i);
        }
    }

    void setAttack(int i,int j,int n,int[][] attacks,int value,int check)
    {
        for (int k=0;k<n;k++)
        {
            if(attacks[k][j]==check)
                attacks[k][j]=value;
        }

        int l=j,r=j;
        for (int k=i;k<n;k++)
        {
            if(l>=0&&attacks[k][l]==check)
                attacks[k][l]=value;
            if(r<n&&attacks[k][r]==check)
                attacks[k][r]=value;
            l--;
            r++;
        }
        l=j;
        r=j;
        for (int k=i;k>=0;k--)
        {
            if(l>=0&&attacks[k][l]==check)
                attacks[k][l]=value;
            if(r<n&&attacks[k][r]==check)
                attacks[k][r]=value;
            l--;
            r++;
        }
    }
}
