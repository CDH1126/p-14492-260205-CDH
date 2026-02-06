package app;

import test.TestUtil;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {

    public static String run(String input) {
        Scanner sc = TestUtil.genScanner(input + "\n종료"); // Scanner를 얻어와야 함
                                // 마지막에 종료 입력값 받아서 자동으로 종료되도록 설정
        ByteArrayOutputStream outputStream = TestUtil.setOutByteArray();
        new App(sc).run();

        return outputStream.toString();
    }
}
