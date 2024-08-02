package leetCode.question;

public class leetCode459 {

    public static boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        for (int i = 1; i <= length /2; i++){
            String substring = s.substring(0, i);
            String str = s.replaceAll(substring, "");
            if (str.equals("")){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
    }
}
