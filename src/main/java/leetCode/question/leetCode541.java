package leetCode.question;

public class leetCode541 {

//    public static String reverseStr(String s, int k) {
//        StringBuilder sb = new StringBuilder();
//        int length = s.length();
//        int n = length / (2 * k);
//        for (int i = 0; i <= n; i++){
//            String substring = s.substring(i * 2 * k, (i + 1) * 2 * k > length ? length:(i + 1) * 2 * k);
//            String deal = deal(substring, k);
//            sb.append(deal);
//        }
//        return sb.toString();
//    }
//
//    public static String deal(String s, int k){
//        StringBuilder sb = new StringBuilder();
//        int length = s.length();
//        if (length <= k ){
//            return reverseString(s);
//        }else{
//            String substring = s.substring(0, k);
//            substring = reverseString(substring);
//            sb.append(substring);
//            sb.append(s.substring(k));
//        }
//        return sb.toString();
//    }
//
//    public static String reverseString(String str) {
//        char[] s = str.toCharArray();
//        if (s == null){
//            return "";
//        }
//        if (s.length == 1){
//            return str;
//        }
//        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
//            char k = s[i];
//            s[i] = s[j];
//            s[j] = k;
//        }
//        return String.valueOf(s);
//    }

    public static String reverseStr(String s, int k) {
        if (s.length() <= 1) {
            return s;
        }
        String result = "";
        int endindex = s.length()-1;
        for(int i = 0; i < s.length();){
            String sub = s.substring(i, i+k > endindex? endindex+1:i+k);
            String rev = reverseString(sub);
            result  = result + rev;
            if (i+k >= s.length()) {
                break;
            }
            result = result + s.substring(i+k, i+2*k > endindex ? endindex+1:i+2*k);
            i = i + 2*k;
        }
        return result;
    }
    public static String reverseString(String str) {
        char[] s = str.toCharArray();
        if (s.length <= 1){
            return new String(s);
        }
        for (int i = 0, j = s.length-1; i < j; i++, j--){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        return new String(s);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        String s1 = reverseStr(s, 1);
        System.out.println(s1);
    }

}
