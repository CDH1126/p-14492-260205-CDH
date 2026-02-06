package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtilTest {

    @Test
    @DisplayName("test.TestUtil.genScanner()")
    void t1() {
        Scanner sc = TestUtil.genScanner("""
                등록
                현재를 사랑하라.
                작자미상
                """);

        String cmd = sc.nextLine();
        String content = sc.nextLine();
        String author = sc.nextLine();

        assertThat(cmd).isEqualTo("등록");
        assertThat(content).isEqualTo("현재를 사랑하라.");
        assertThat(author).isEqualTo("작자미상");

    }

    @Test
    @DisplayName("test.TestUtil.setOutByArray()")
    void t2() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutByteArray();

        System.out.println("1 / 이순신 / 나의 죽음을 적에게 알리지 마라");

        String rst = byteArrayOutputStream.toString();

        TestUtil.clearSetOutToByteArray(byteArrayOutputStream); // 이걸 해야 출력 결과 나옴

        System.out.println("출력결과: " + rst); //

        assertThat(rst).contains("1 / 이순신 / 나의 죽음을 적에게 알리지 마라"); // 문자열은 자동 줄바꿈으로 인해 .contains() 사용

    }
//    @Test
//    @DisplayName("등록")
//    void t1() {
//        final String out = test.TestUtil.run("""
//                등록
//                현재를 사랑하라.
//                작자미상
//                """);
//
//        assertThat(out)
//                .contains("명언 : ")
//                .contains("작가 : ")
//                .contains("1번 명언이 등록되었습니다.");

}
