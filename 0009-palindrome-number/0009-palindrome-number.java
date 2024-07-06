class Solution {
    public boolean isPalindrome(int x) {
        int tmp = x;
        int b = 0;
        int rem = 0;
        while(tmp>0)
        {
            rem=tmp%10;
            b=(b*10)+rem;
            tmp=tmp/10;
        }
        if(b==x)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}