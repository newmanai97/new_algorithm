package leetCode.question;

import java.util.*;


public class leetCode17 {
    Map<Character, List<Character>> keyMap = new HashMap<>();

    List<String> res = new ArrayList<>();
    LinkedList<Character> path = new LinkedList<>();

    private void initKeyMap() {
        // 2: a,b,c
        keyMap.put('2', Arrays.asList('a', 'b', 'c'));
        // 3: d,e,f
        keyMap.put('3', Arrays.asList('d', 'e', 'f'));
        // 4: g,h,i
        keyMap.put('4', Arrays.asList('g', 'h', 'i'));
        // 5: j,k,l
        keyMap.put('5', Arrays.asList('j', 'k', 'l'));
        // 6: m,n,o
        keyMap.put('6', Arrays.asList('m', 'n', 'o'));
        // 7: p,q,r,s
        keyMap.put('7', Arrays.asList('p', 'q', 'r', 's'));
        // 8: t,u,v
        keyMap.put('8', Arrays.asList('t', 'u', 'v'));
        // 9: w,x,y,z
        keyMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        initKeyMap();
        if (digits.length() == 0) return res;
        backtracking(digits, 0);
        return res;
    }

    public void backtracking(String digits, int index){
        if (digits.length() < index + 1){
            StringBuilder sb = new StringBuilder();
            for (Character c : path) {
                sb.append(c); // 追加每个字符
            }
            String result = sb.toString();
            res.add(result);
            return;
        }

        List<Character> list = keyMap.get(digits.charAt(index));
        for (int i = 0; i < list.size(); i++){
            path.add(list.get(i));
            backtracking(digits, index+1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        leetCode17 solution = new leetCode17();
        solution.letterCombinations("23");
    }
}
