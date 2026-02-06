import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {

    public static String run(String input) {
        Scanner sc = TestUtil.genScanner(input); // Scanner를 얻어와야 함

        ByteArrayOutputStream outputStream = TestUtil.setOutByteArray();
        new App(sc).run();

        return outputStream.toString();
    }
}
