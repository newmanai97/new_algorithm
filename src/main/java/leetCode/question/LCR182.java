package leetCode.question;

public class LCR182 {

    public static String dynamicPassword(String password, int target) {
        StringBuilder sb = new StringBuilder();
        String substring1 = password.substring(0, target);
        String substring2 = password.substring(target);
        sb.append(substring2).append(substring1);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(dynamicPassword("s3cur1tyC0d3", 4));
    }
}
