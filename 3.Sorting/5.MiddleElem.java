class Solution {
    int middle(int a, int b, int c) {
        if((a>b && a<c) || (a>c && a<b)){
            return a;
        }else if((b>a && b<c) ||(b>c && b<a)){
            return b;
        }else if((c>a && c<b) || (c>b && c<a)){
            return c;
        }
        return -1;
    }
}