package others;

public class Rabin {

    public static void main(String args[]){
        String shortStr = "abc";
        String longStr = "dabc";
        int sHash = calculateHash(shortStr);
        int lHash = calculateHash(longStr.substring(0,3));
        int currentIdx = 0;
        if(sHash == lHash){
            System.out.print(currentIdx);
            return;
        }
        int slen = shortStr.length();
        for (int i = slen; i< longStr.length(); i++) {
            currentIdx += 1;
            lHash = (int)((( lHash-(Math.pow(10.0,slen-1)*(longStr.charAt(i-slen)-'a')) )*10+(longStr.charAt(i)-'a'))% 31)+31;
            if(lHash == sHash){
                System.out.print(currentIdx);
                return;
            }
        }
    }

    public static int calculateHash(String s){
        int res=0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 10 + (s.charAt(i)-'a');
        }
        return res%31;
    }
}
