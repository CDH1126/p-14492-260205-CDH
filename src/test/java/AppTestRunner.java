import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {

    public static String run(String input) {
        Scanner sc = TestUtil.genScanner("종료"); // Scanner를 얻어와야 함

        ByteArrayOutputStream outputStream = TestUtil.setOutByteArray();
        new App(sc).run();

        return outputStream.toString();
    }
}
