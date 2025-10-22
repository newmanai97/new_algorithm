package leetCode.question;

public class leetCode738 {
    public int monotoneIncreasingDigits1(int n) {
        String num = String.valueOf(n);
        if (num.length() <=1){
            return n;
        }
        boolean flag = true;
        while (flag){
            if (num.length()  <= 1){
                flag = false;
            }
            for (int i  = 1; i < num.length(); i++) {
                if (num.charAt(i-1) > num.charAt(i)) {
                    char fir = (char)(num.charAt(i-1)-1);
                    StringBuilder sb = new StringBuilder();
                    sb.append(num.substring(0,i-1));
                    sb.append(fir);
                    for (int j= num.length()-i; j > 0; j--) {
                        sb.append('9');
                    }
                    num = String.valueOf(Integer.parseInt(sb.toString()));
                    break;
                }
                if (i == num.length()-1){
                    flag = false;
                }
            }
        }
        return Integer.parseInt(num);
    }


    public int monotoneIncreasingDigits(int n) {
        char[] narr = String.valueOf(n).toCharArray();
        int start = narr.length;

        for (int i = narr.length-2; i >= 0; i--){
            if (narr[i] > narr[i+1]){
                narr[i] = (char) (narr[i]-1);
                start = i+1;
            }
        }
        for (int i = start; i < narr.length; i++){
            narr[i] = '9';
        }
        return Integer.parseInt(String.valueOf(narr));
    }
}
