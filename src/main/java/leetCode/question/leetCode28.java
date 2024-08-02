package leetCode.question;

public class leetCode28 {

    public static int strStr(String haystack, String needle) {
        char[] charArray = haystack.toCharArray();
        int len = charArray.length;
        char c = needle.charAt(0);
        int nlen = needle.length();
        for (int i = 0; i < len; i++) {
            if (charArray[i] == c) {
                if (i + nlen > len){
                    return -1;
                }
                String substring = haystack.substring(i, i + nlen);
                if (substring.equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println(strStr( "saabutsad", "sad"));
    }
}
