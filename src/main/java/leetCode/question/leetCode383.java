package leetCode.question;

import java.util.HashMap;
import java.util.Map;

public class leetCode383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer>  map = new HashMap<Character, Integer>();
        char[] charArray = magazine.toCharArray();
        for (char c : charArray) {
            if (map.containsKey(c)){
                Integer i = map.get(c);
                map.put(c, ++i);
            }else {
                map.put(c, 1);
            }
        }
        char[] ransomNoteCharArray = ransomNote.toCharArray();
        for (char c : ransomNoteCharArray) {
            if (map.containsKey(c)){
                Integer i = map.get(c);
                if (i > 1){
                    map.put(c, --i);
                } else if (i == 1) {
                    map.remove(c);
                }
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "aab";
        System.out.println(canConstruct(s1, s2));

    }
}
