class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int content = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = s.length-1;
        int i = g.length-1;
        while(j>=0 && i>=0)
        {
            if(s[j] >= g[i])
            {
                content++;
                j--;
                i--;
            }
            else
            {
                i--;
            }
        }
        return content;
    }
}