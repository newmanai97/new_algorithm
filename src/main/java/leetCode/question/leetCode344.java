package leetCode.question;

public class leetCode344 {
    public static void reverseString(char[] s) {
        if (s == null || s.length == 1){
            return;
        }
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char k = s[i];
            s[i] = s[j];
            s[j] = k;
        }
    }

    public static void main(String[] args) {
        String  o= "hello";
        char[] s = o.toCharArray();
        reverseString(s);
        for (char c : s) {
            System.out.println(c);
        }

    }
}
