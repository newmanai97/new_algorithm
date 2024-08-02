package leetCode.question;

public class LCR122 {

    public static String pathEncryption(String path) {
        return path.replaceAll("\\.", " ");
    }

    public static void main(String[] args) {
        System.out.println(pathEncryption( "a.aef.qerf.bb"));
    }
}
