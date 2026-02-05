import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // "aaa\nbbb\nccc"
        Scanner sc = new Scanner("""
                aaa
                과거에 집착하지 마라.
                작자 미상
                ddd
                """);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String str3 = sc.nextLine();
        String str4 = sc.nextLine();

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);

    }
}
