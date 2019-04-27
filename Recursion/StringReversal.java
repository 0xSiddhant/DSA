
public class StringReversal {

    public static void main(String[] args) {

        String s = "Hello World";
        System.out.println(rev(s));
    }

    public static String rev(String str) {
        if (str.length() <= 1 || str == null) {
            return str;
        }
        return rev(str.substring(1)) + str.charAt(0);
    }

}
